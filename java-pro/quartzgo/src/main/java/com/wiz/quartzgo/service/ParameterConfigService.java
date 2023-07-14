package com.wiz.quartzgo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wiz.quartzgo.entity.ParameterConfig;

/**
* @author admin
* @description 针对表【parameter_config(参数配置表)】的数据库操作Service
* @createDate 2023-07-14 11:05:12
*/
public interface ParameterConfigService extends IService<ParameterConfig> {
    ParameterConfig getParameterConfigById(Long id);
}
