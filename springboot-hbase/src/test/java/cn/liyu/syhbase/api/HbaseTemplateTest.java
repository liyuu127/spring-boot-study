package cn.liyu.syhbase.api;

import cn.liyu.syhbase.Application;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:test.properties")
public class HbaseTemplateTest {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(HbaseTemplateTest.class);
    @Autowired
    HbaseTemplate hbaseTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test_get_coon() throws IOException {
        Connection connection = hbaseTemplate.getConnection();
        Admin admin = connection.getAdmin();
        for (TableName tableName : admin.listTableNames()) {
            System.out.println("tableName = " + tableName);
        }
        Assert.assertNotNull(connection);

    }


    @Test
    public void test_get_conn() {
        final String TABLE_NAME = "mytable";
        final String CF_DEFAULT = "cf";
        final byte[] QUALIFIER = "col1".getBytes();
        final byte[] ROWKEY = "rowkey1".getBytes();

        Configuration config = HBaseConfiguration.create();
        //ZK地址
        String zkAddress = "172.16.1.163:2181";
        config.set(HConstants.ZOOKEEPER_QUORUM, zkAddress);
        Connection connection = null;

        try {
            connection = ConnectionFactory.createConnection(config);

            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(TABLE_NAME));
            tableDescriptor.addFamily(new HColumnDescriptor(CF_DEFAULT));
            System.out.print("Creating table. ");
            Admin admin = connection.getAdmin();
            admin.createTable(tableDescriptor);
            System.out.println(" Done.");
            Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
            try {
                Put put = new Put(ROWKEY);
                put.addColumn(CF_DEFAULT.getBytes(), QUALIFIER, "this is value".getBytes());
                table.put(put);
                Get get = new Get(ROWKEY);
                Result r = table.get(get);
                byte[] b = r.getValue(CF_DEFAULT.getBytes(), QUALIFIER);  // returns current version of value
                System.out.println(new String(b));
            } finally {
                if (table != null) table.close();
            }
        } catch (Exception e) {
            log.error("operator error", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    log.error("close error", e);
                }
            }
        }
    }

    @Test
    public void test_DataSource(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT state as \"State\",count(city) as \"City Count\",sum(population) as \"Population Sum\"\n" +
                "FROM us_population\n" +
                "GROUP BY state\n" +
                "ORDER BY sum(population) DESC");
        log.debug("data:{}",maps);
        System.out.println("maps = " + maps);
    }
}