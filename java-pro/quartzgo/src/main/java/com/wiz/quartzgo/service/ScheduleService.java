package com.wiz.quartzgo.service;

import com.wiz.quartzgo.entity.ParameterConfig;
import com.wiz.quartzgo.util.ScheduleUtils;
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
