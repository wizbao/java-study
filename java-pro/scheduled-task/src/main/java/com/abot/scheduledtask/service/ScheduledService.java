package com.abot.scheduledtask.service;

import com.abot.scheduledtask.entity.ScheduledEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author admin
* @description 针对表【scheduled(定时任务配置表)】的数据库操作Service
* @createDate 2023-09-28 11:16:30
*/
public interface ScheduledService extends IService<ScheduledEntity> {

    void startMyTask(Integer id);

}
