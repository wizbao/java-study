package com.abot.mybatisplusgo.mapper;

import com.abot.mybatisplusgo.entity.User;
import com.abot.mybatisplusgo.mapper.sqlprovider.UserProvider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

/**
 * @author admin
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2023-06-15 14:40:41
 * @Entity generator.entity.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //    @SelectProvider(type = UserProvider.class,method = "selectUserByIds")
    @Select("<script>" +
            "select * from user where id in " +
            "<foreach collection='ids' item='id' open='(' close=')' separator=','>#{id}</foreach>" +
            "</script>")
    List<User> selectUserByIds(@Param("ids") List<Long> ids);

    /**
     * 批量更新,记得在url添加allowMultiQueries=true,否则报错
     *
     * @param users
     * @return
     */
    @Update({"<script>",
            "<foreach collection='users' item='item'  separator=';'>",
            "update `user`",
            "<set>",
            "<if test='item.username!=null'>`username`=#{item.username},</if>",
            "<if test='item.password!=null'>`password`=#{item.password},</if>",
            "<if test='item.remark!=null'>`remark`=#{item.remark},</if>",
            "</set>",
            "where `id` = #{item.id} ",
            "</foreach>",
            "</script>"})
    void updateBatch(@Param("users") List<User> users);

    @Update("<script>" +
            "update user " +
            "<set>" +
            "<trim suffixOverrides=','>" +
            "<if test='username!=null'>username=#{username},</if>" +
            "<if test='password!=null'>password=#{password},</if>" +
            "<if test='remark!=null'>remark=#{remark},</if>" +
            "</trim>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    boolean updateOne(User user);

    /**
     * 批量插入
     * @param users
     * @return
     */
    @Insert("<script>" +
            "insert into user(username,password,remark) values " +
            "<foreach collection='users' item='item' separator=','>" +
            "(#{item.username},#{item.password},#{item.remark})" +
            "</foreach>" +
            "</script>")
    boolean insertBatch(@Param("users") List<User> users);
}




