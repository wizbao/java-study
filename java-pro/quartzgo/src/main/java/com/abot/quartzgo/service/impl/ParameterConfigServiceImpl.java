package com.abot.quartzgo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.abot.quartzgo.entity.ParameterConfig;
import com.abot.quartzgo.mapper.ParameterConfigMapper;
import com.abot.quartzgo.service.ParameterConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【parameter_config(参数配置表)】的数据库操作Service实现
* @createDate 2023-07-14 11:05:12
*/
@Service
public class ParameterConfigServiceImpl extends ServiceImpl<ParameterConfigMapper, ParameterConfig>
    implements ParameterConfigService {

    @Autowired
    private ParameterConfigMapper mapper;

    @Override
    public ParameterConfig getParameterConfigById(Long id) {
       return mapper.selectById(id);
    }

}




