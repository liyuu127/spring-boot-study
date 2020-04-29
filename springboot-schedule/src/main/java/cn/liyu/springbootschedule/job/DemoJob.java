package cn.liyu.springbootschedule.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author liyu
 * @date 2020/4/28 17:33
 * @description
 */
@DisallowConcurrentExecution
public class DemoJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("~~ DemoJob 启动运行汇总~~");
    }
}