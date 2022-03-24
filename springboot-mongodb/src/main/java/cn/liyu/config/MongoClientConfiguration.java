//package cn.liyu.config;
//
//import com.mongodb.MongoClientSettings;
//import org.bson.UuidRepresentation;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//
////@Configuration
//public class MongoClientConfiguration extends AbstractMongoClientConfiguration {
//    @Override
//    protected String getDatabaseName() {
//        return "test";
//    }
//
//    /**
//     *  Auto Index Creation
//     * @return
//     */
//    @Override
//    protected boolean autoIndexCreation() {
//        return true;
//    }
//
//    /**
//     * UUID Types
//     * @param builder
//     */
//    @Override
//    public void configureClientSettings(MongoClientSettings.Builder builder) {
//        builder.uuidRepresentation(UuidRepresentation.STANDARD);
//    }
//}
