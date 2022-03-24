package cn.liyu;

import cn.liyu.dao.IUserDao;
import cn.liyu.pojo.Person;
import cn.liyu.pojo.Student;
import cn.liyu.pojo.User;
import cn.liyu.pojo.Venue;
import cn.liyu.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationUpdate;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.ComparisonOperators.Gte.valueOf;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Switch.CaseOperator.when;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

/**
 * @author liyu
 * @date 2020/5/8 16:49
 * @description
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class MongoTest {

    @Autowired
    IUserService iUserService;
    @Autowired
    IUserDao iUserDao;
    @Autowired
    MongoTemplate mongoTemplate;


    @Test
    public void insert_one_user_test() {
        User user = new User();
        user.setId(1002);
        user.setUid(3);
        user.setName("李宇");
        user.setAge(19);
        user.setDate(new Date());
        user.setAddress("朝阳区");
        User insert = iUserDao.insert(user);
    }

    /**
     * 测试继承的MongoDB仓库的通用方法
     */
    @Test
    public void testIUserDao() {
//        User user = new User();
//        user.setId(1002);
//        user.setUid(3);
//        user.setName("李宇");
//        user.setAge(19);
//        user.setDate(new Date());
//        user.setAddress("朝阳区");
//        System.out.println("user.toString() = " + user.toString());
//        User insert = iUserDao.insert(user);
//        System.out.println("insert.toString() = " + insert.toString());

        List<User> user = iUserDao.findByName("李宇");
        user.forEach(user1 -> System.out.println(user1.toString()));
    }

    /**
     * mongoTemplate使用
     */
    @Test
    public void testMongoTemplate() {

        Person p = new Person("Joe", 34);

        // mongoTemplate is used to initially store the object into the database.
        mongoTemplate.insert(p);
        log.info("Insert: " + p);

        // Find
        p = mongoTemplate.findById(p.getId(), Person.class);
        log.info("Found: " + p);

        // Update
        mongoTemplate.updateFirst(query(where("name").is("Joe")), update("age", 35), Person.class);
        p = mongoTemplate.findOne(query(where("name").is("Joe")), Person.class);
        log.info("Updated: " + p);

        // Delete
        mongoTemplate.remove(p);

        // Check that deletion worked
        List<Person> people = mongoTemplate.findAll(Person.class);
        log.info("Number of people = : " + people.size());


        mongoTemplate.dropCollection(Person.class);
    }

    /**
     * “Upserting” Documents in a Collection
     */
    @Test
    public void upserting_test() {
        mongoTemplate.update(Person.class)
                .matching(query(where("ssn").is(1111).and("firstName").is("Joe").and("Fraizer").is("Update")))
                .apply(update("address", "addr"))
                .upsert();
    }

    /**
     * The findAndModify(…) method on MongoCollection can update a document and return either the old or newly updated document in a single operation. MongoTemplate provides four findAndModify overloaded methods that take Query and Update classes and converts from Document to your POJOs
     */
    @Test
    public void finding_and_upserting_documents_in_a_collection_test() {
        mongoTemplate.insert(new Person("Tom", 21));
        mongoTemplate.insert(new Person("Dick", 22));
        mongoTemplate.insert(new Person("Harry", 23));

        Query query = new Query(Criteria.where("name").is("Harry"));
        Update update = new Update().inc("age", 1);

        Person oldValue = mongoTemplate.update(Person.class)
                .matching(query)
                .apply(update)
                .findAndModifyValue(); // return's old person object

        assertThat(oldValue.getName()).isEqualTo("Harry");
        assertThat(oldValue.getAge()).isEqualTo(23);

        Person newValue = mongoTemplate.query(Person.class)
                .matching(query)
                .stream().findFirst().get();

        assertThat(newValue.getAge()).isEqualTo(24);

        Person newestValue = mongoTemplate.update(Person.class)
                .matching(query)
                .apply(update)
                .withOptions(FindAndModifyOptions.options().returnNew(true)) // Now return the newly updated document when updating
                .findAndModifyValue();

        assertThat(newestValue.getAge()).isEqualTo(25);

        Person upserted = mongoTemplate.update(Person.class)
                .matching(new Query(Criteria.where("firstName").is("Mary")))
                .apply(update)
                .withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
                .findAndModifyValue();

        assertThat(upserted.getName()).isEqualTo("Mary");
        assertThat(upserted.getAge()).isOne();
    }

    /**
     * https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.aggregation
     * AggregationUpdate.set(…).toValue(…) → $set : { … }
     * AggregationUpdate.unset(…) → $unset : [ … ]
     * AggregationUpdate.replaceWith(…) → $replaceWith : { … }
     */
    public void aggregation_pipeline_updates_test() {


//        db.students.update(
//                { },
//                [
//                { $set: { average : { $avg: "$tests" } } },
//        { $set: { grade: { $switch: {
//            branches: [
//            { case: { $gte: [ "$average", 90 ] }, then: "A" },
//            { case: { $gte: [ "$average", 80 ] }, then: "B" },
//            { case: { $gte: [ "$average", 70 ] }, then: "C" },
//            { case: { $gte: [ "$average", 60 ] }, then: "D" }
//                           ],
//            default: "F"
//        } } } }
//   ],
//        { multi: true }
//)

    }

    @Test
    /**
     * The @Version annotation provides syntax similar to that of JPA in the context of MongoDB and makes sure updates are only applied to documents with a matching version. Therefore, the actual value of the version property is added to the update query in such a way that the update does not have any effect if another operation altered the document in the meantime. In that case, an OptimisticLockingFailureException is thrown. The following example shows these features:
     */
    public void Optimistic_Locking_test() {
        //	Intially insert document. version is set to
        Person daenerys = mongoTemplate.insert(new Person("Daenerys"));
        //Load the just inserted document. version is still 0.
        Person tmp = mongoTemplate.findOne(query(where("id").is(daenerys.getId())), Person.class);
        daenerys.setLastname("Targaryen");
        //Update the document with version = 0. Set the lastname and bump version to 1.
        mongoTemplate.save(daenerys);
//        Try to update the previously loaded document that still has version = 0. The operation fails with an OptimisticLockingFailureException, as the current version is 1.
        mongoTemplate.save(tmp); // throws OptimisticLockingFailureException
    }

    /**
     * MongoDB supports GeoSpatial queries through the use of operators such as $near, $within, geoWithin, and $nearSphere. Methods specific to geospatial queries are available on the Criteria class. There are also a few shape classes (Box, Circle, and Point) that are used in conjunction with geospatial related Criteria methods.
     */
    @Test
    public void GeoSpatial_Queries_test(){
//        Circle circle = new Circle(-73.99171, 40.738868, 0.01);
//        List<Venue> venues =
//                mongoTemplate.find(new Query(Criteria.where("location").within(circle)), Venue.class);

//        Circle circle = new Circle(-73.99171, 40.738868, 0.003712240453784);
//        List<Venue> venues =
//                mongoTemplate.find(new Query(Criteria.where("location").withinSphere(circle)), Venue.class);

//        Point point = new Point(-73.99171, 40.738868);
//        List<Venue> venues =
//                mongoTemplate.find(new Query(Criteria.where("location").near(point).maxDistance(0.01)), Venue.class);

        Point point = new Point(-73.99171, 40.738868);
        List<Venue> venues =
                mongoTemplate.find(new Query(
                                Criteria.where("location").nearSphere(point).maxDistance(0.003712240453784)),
                        Venue.class);
        System.out.println("venues = " + venues);
    }
}
