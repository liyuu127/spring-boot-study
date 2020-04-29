package cn.liyu.springbootschedule.config;

import cn.liyu.springbootschedule.job.DemoJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

/**
 * @author liyu
 * @date 2020/4/28 17:15
 * @description
 */
@Configuration
public class QuartzJobConfig {


    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setName("DemoJob");
        jobDetail.setGroup("DemoJob_Group");
        jobDetail.setJobClass(DemoJob.class);
        jobDetail.setDurability(true);
        return jobDetail;
    }

    /**
     * 表达式触发器工厂Bean
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetailFactoryBean().getObject());
        trigger.setCronExpression("*/10 * * * * ?");
        trigger.setName("DemoJob");
        trigger.setMisfireInstruction(0);

        return trigger;
    }

}
