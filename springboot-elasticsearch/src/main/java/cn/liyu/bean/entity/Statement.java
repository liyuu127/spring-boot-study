package cn.liyu.bean.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.join.JoinField;

@Document(indexName = "statements")
@Routing("routing")
@Data
//@Routing("@myBean.getRouting(#entity)")
public class Statement {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String text;

    @Field(type = FieldType.Keyword)
    private String routing;

    @JoinTypeRelations(
            relations =
                    {
                            @JoinTypeRelation(parent = "question", children = {"answer", "comment"}),
                            @JoinTypeRelation(parent = "answer", children = "vote")
                    }
    )
    private JoinField<String> relation;

    private Statement() {
    }

    public static StatementBuilder builder() {
        return new StatementBuilder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JoinField<String> getRelation() {
        return relation;
    }

    public void setRelation(JoinField<String> relation) {
        this.relation = relation;
    }

    public static final class StatementBuilder {
        private String id;
        private String text;
        private String routing;
        private JoinField<String> relation;

        private StatementBuilder() {
        }

        public StatementBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public StatementBuilder withRouting(String routing) {
            this.routing = routing;
            return this;
        }

        public StatementBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public StatementBuilder withRelation(JoinField<String> relation) {
            this.relation = relation;
            return this;
        }

        public Statement build() {
            Statement statement = new Statement();
            statement.setId(id);
            statement.setRouting(routing);
            statement.setText(text);
            statement.setRelation(relation);
            return statement;
        }
    }
}
