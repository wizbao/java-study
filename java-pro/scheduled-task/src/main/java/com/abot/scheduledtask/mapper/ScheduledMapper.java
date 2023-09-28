package com.abot.scheduledtask.mapper;

import com.abot.scheduledtask.entity.ScheduledEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【scheduled(定时任务配置表)】的数据库操作Mapper
* @createDate 2023-09-28 11:16:30
* @Entity com.abot.scheduledtask.entity.Scheduled
*/
@Mapper
public interface ScheduledMapper extends BaseMapper<ScheduledEntity> {

}




