package com.abot.easyexcelgo.mapper;

import com.abot.easyexcelgo.POJO.PO.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 韦小宝
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-07-16 16:39:54
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
     boolean batchInsert(List<User> users);
}




