package cn.liyu.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author liyu
 * date 2020/8/5 16:15
 * description 配置的任务Job必须注册到Spring IOC容器中，并且任务的名称和步骤的名称组成唯一
 * 重新启动项目，控制台并不会再次打印出任务执行日志，因为Job名称和 Step名称组成唯一，执行完的不可重复的任务，不会再次执行。
 */
@Component
public class FirstJobDemo {

    /**
     * 任务创建工厂
     */
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    /**
     * 步骤创建工厂
     */
    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job firstJob() {

        Job job = jobBuilderFactory
                //创建一个指定名称的任务
                .get("firstJob")
                //指定任务的开始步骤
                .start(stepBuilderFactory.get("step")
                        //步骤Step由若干个小任务Tasklet组成,通过tasklet方法创建
                        .tasklet((stepContribution, chunkContext) -> {
                            System.out.println("执行步骤...");
                            return RepeatStatus.FINISHED;
                        }).build())
                .build();
        return job;
    }
}
