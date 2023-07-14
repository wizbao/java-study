package com.wiz.quartzgo.task;

import com.wiz.quartzgo.entity.ParameterConfig;
import com.wiz.quartzgo.service.ParameterConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author weibao
 */
@Component
public class ScheduleTask {

    @Autowired
    private ParameterConfigService parameterConfigService;
    public void loop(){
        System.out.println(getCron());
    }

    public String getCron(){
        ParameterConfig param = parameterConfigService.getParameterConfigById(1L);
        if (param != null) {
           return param.getValue();
        }
        return "";

    }
}
