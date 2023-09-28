package com.abot.scheduledtask.service.impl;

import com.abot.scheduledtask.entity.ScheduledEntity;
import com.abot.scheduledtask.mapper.ScheduledMapper;
import com.abot.scheduledtask.schedule.MyScheduleTask;
import com.abot.scheduledtask.service.ScheduledService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author admin
 * @description 针对表【scheduled(定时任务配置表)】的数据库操作Service实现
 * @createDate 2023-09-28 11:16:30
 */
@Service
public class ScheduledServiceImpl extends ServiceImpl<ScheduledMapper, ScheduledEntity>
        implements ScheduledService {

    @Resource
    private MyScheduleTask scheduleTask;

    @Override
    public void startMyTask(Integer id) {
        ScheduledEntity scheduled = getById(id);
        String cron = scheduled.getCron();
        System.out.println(cron);
        scheduleTask.init(() -> System.out.println("hello world"), cron);
    }
}




