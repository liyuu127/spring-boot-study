package cn.liyu.springbootkafka.entity;

/**
 * @author liyu
 * date 2021/3/4 14:54
 * description
 */
public class LogLine {
    private String payload;
    private Object schema;

    public String getPayload() {
        return payload;
    }
}
