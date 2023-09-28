package com.abot.common.util;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Date;
import java.util.Objects;

/**
 * Dao工具类，封装一些公用的Dao逻辑处理
 *
 * @author luoj
 * @date 2020-06-05
 */
public class DaoUtil {

    private DaoUtil() {}

    /**
     * 拼接标签条件sql
     *
     * @param queryWrapper 条件构造器
     * @param tags 标签
     */
    public static void appendTagsCondition(QueryWrapper<?> queryWrapper, String tags) {
        if (StrUtil.isBlank(tags)) { return; }

        // 初始化查找函数
        String functionSql = "find_in_set({0}, tags) > 0";
        String[] arr = tags.split(",");
        if (arr.length == 1) {
            queryWrapper.apply(functionSql, tags);
        } else {
            // 多个标签动态拼接查询条件，条件之间用或连接
            queryWrapper.and(wrapper -> {
                for (int i=0; i<arr.length; i++) {
                    if (i == 0) {
                        wrapper.apply(functionSql, arr[0]);
                    } else {
                        wrapper.or().apply(functionSql, arr[i]);
                    }
                }
            });
        }
    }

    /**
     * 拼接字符类型字段的相等条件
     *
     * @param queryWrapper 条件构造器
     * @param column 列名
     * @param value 值
     */
    public static void appendStringEqualCondition(QueryWrapper<?> queryWrapper, String column, String value) {
        if (StrUtil.isNotBlank(value)) {
            queryWrapper.eq(column, value);
        }
    }

    /**
     * 拼接字符类型字段的模糊匹配条件
     *
     * @param queryWrapper 条件构造器
     * @param column 列名
     * @param value 值
     */
    public static void appendStringLikeCondition(QueryWrapper<?> queryWrapper, String column, String value) {
        if (StrUtil.isNotBlank(value)) {
            queryWrapper.like(column, value);
        }
    }

    /**
     * 拼接对象类型字段的相等条件
     *
     * @param queryWrapper 条件构造器
     * @param column 列名
     * @param value 值
     */
    public static void appendObjectEqualCondition(QueryWrapper<?> queryWrapper, String column, Object value) {
        if (Objects.nonNull(value)) {
            queryWrapper.eq(column, value);
        }
    }

    /**
     * 拼接日期时间类型字段的范围比较条件
     *
     * @param queryWrapper 条件构造器
     * @param column 列名
     * @param start 开始时间
     * @param end 结束时间
     */
    public static void appendDateBetweenCondition(QueryWrapper<?> queryWrapper, String column, Date start, Date end) {
        if (StrUtil.isNotBlank(column) && Objects.nonNull(start) && Objects.nonNull(end)) {
            queryWrapper.between(column, start, end);
        }
    }
}
