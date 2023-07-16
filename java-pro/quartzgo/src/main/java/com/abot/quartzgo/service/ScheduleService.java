package com.abot.quartzgo.service;

import com.abot.quartzgo.entity.ParameterConfig;
import com.abot.quartzgo.util.ScheduleUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weibao
 */
@Service
public class ScheduleService {
    @Autowired
    private Scheduler scheduler;

    public void resumeJob(ParameterConfig config) throws SchedulerException {
        scheduler.resumeJob(ScheduleUtils.getJobKey(config.getId(), config.getName()));
    }

}
