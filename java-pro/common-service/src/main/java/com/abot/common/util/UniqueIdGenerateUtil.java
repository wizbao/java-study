package com.abot.common.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.abot.common.constant.RedisConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author gao
 * @date 2023/8/3 10:38
 */

@Component
@Slf4j
public class UniqueIdGenerateUtil {

    public static StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        UniqueIdGenerateUtil.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 每秒最多生成多少个id
     */
    private final static Integer LIMIT = 9999;

    /**
     * key过期时间 1.5s
     */
    private final static Integer EXPIRE = 1500;

    public static Long uniqueIdGenerate() {
        try {
            List<String> keys = Collections.singletonList(RedisConstant.UNIQUE_ID_GENERATE);
            DefaultRedisScript<String> script = new DefaultRedisScript<>(RedisConstant.ID_GENERATE_LUA_SCRIPT, String.class);
            String execute = stringRedisTemplate.execute(script, keys, String.valueOf(LIMIT), String.valueOf(EXPIRE));

            String[] split = execute.split(",");
            long second = Long.parseLong(split[0]);
            long microSecond = Long.parseLong(split[1]);
            long nowTime = (second * 1000000 + microSecond) / 1000;
            String ascNo = String.format("%04d", Long.valueOf(split[2]));

            String orderNo = DateUtil.format(DateUtil.date(nowTime), DatePattern.PURE_DATETIME_MS_FORMAT).substring(2).concat(ascNo);
            return Long.valueOf(orderNo);
        } catch (Exception e) {
            log.error("生成唯一id异常{}", e.getMessage(), e);
            throw new RuntimeException("生成唯一id失败");
        }
    }
}
