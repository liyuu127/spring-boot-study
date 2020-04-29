package cn.liyu.springbootschedule.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author liyu
 * @date 2020/4/28 17:32
 * @description 基本任务管理
 * 基本任务（BatchTask）与任务计划（BatchSchedule）是一对多关系，在 Quartz 代替 jobGroup 的概念
 */
@Setter
@Getter
public class BatchTask {

    /**
     * 任务编码：唯一
     */
    private String code;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 前置任务
     */
    private List<BatchTask> previous;

}
