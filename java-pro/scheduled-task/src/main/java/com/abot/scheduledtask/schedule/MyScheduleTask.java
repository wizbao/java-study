package com.abot.scheduledtask.schedule;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * @author weibao
 */
@Component
@EnableScheduling
public class MyScheduleTask implements SchedulingConfigurer {

    ScheduledTaskRegistrar taskRegistrar;

    private Runnable task;

    private String cron;

    public void init(Runnable task, String cron) {
        this.task = task;
        this.cron = cron;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        this.taskRegistrar = taskRegistrar;
        taskRegistrar.addTriggerTask(initTask(), initTrigger());
    }

    public Runnable initTask() {
        return task;
    }

    public Trigger initTrigger() {
        return triggerContext -> new CronTrigger(cron).nextExecutionTime(triggerContext);
    }
}
