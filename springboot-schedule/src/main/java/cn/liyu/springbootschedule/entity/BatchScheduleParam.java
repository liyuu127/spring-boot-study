package cn.liyu.springbootschedule.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liyu
 * @date 2020/4/28 17:32
 * @description 任务计划参数
 */
@Setter
@Getter
public class BatchScheduleParam {

    /**
     * 任务计划ID
     */
    private String scheduleId;

    /**
     * 任务计划code
     */
    private String scheduleCode;

    /**
     * 参数名
     */
    private String paramName;

    /**
     * 参数值
     */
    private String paramValue;

    /**
     * 动态参数使用
     */
    private String tempId;

}
