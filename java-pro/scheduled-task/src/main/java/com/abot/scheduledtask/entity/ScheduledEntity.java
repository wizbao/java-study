package com.abot.scheduledtask.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 定时任务配置表
 * @TableName scheduled
 */
@TableName(value ="scheduled")
@Data
public class ScheduledEntity implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * cron表达式
     */
    @TableField(value = "cron")
    private String cron;

    /**
     * 是否禁用，0-否 1-是
     */
    @TableField(value = "disabled")
    private Integer disabled;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime update_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}