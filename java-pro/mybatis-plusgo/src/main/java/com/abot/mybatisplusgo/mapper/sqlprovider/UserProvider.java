package com.abot.mybatisplusgo.mapper.sqlprovider;


import org.apache.ibatis.builder.annotation.ProviderContext;

import java.util.List;

/**
 * @author weibao
 */
public class UserProvider {
    public String selectUserByIds(ProviderContext context) {
        return "<script>" +
                "select * from user where id in " +
                "<foreach collection='ids' item='id' open='(' close=')' separator=','>#{id}</foreach>" +
                "</script>";
    }
}
