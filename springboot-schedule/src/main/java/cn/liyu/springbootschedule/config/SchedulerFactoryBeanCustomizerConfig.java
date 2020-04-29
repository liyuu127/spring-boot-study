package cn.liyu.springbootschedule.config;

import cn.liyu.springbootschedule.listener.CustomGlobalJobListener;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author liyu
 * @date 2020/4/28 17:16
 * @description SchedulerFactoryBean 自定义配置
 */
@Configuration
public class SchedulerFactoryBeanCustomizerConfig implements SchedulerFactoryBeanCustomizer {

    /**
     * 全局监听器
     *
     * @return
     */
    @Bean
    public CustomGlobalJobListener globalJobListener() {
        return new CustomGlobalJobListener();
    }


    @Override
    public void customize(SchedulerFactoryBean schedulerFactoryBean) {
        schedulerFactoryBean.setGlobalJobListeners(globalJobListener());
    }
}
