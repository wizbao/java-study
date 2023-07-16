package com.abot.easyexcelgo.POJO.PO;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    /**
     * 主键
     *  @ExcelIgnore 忽略这个字段
     */
    @ExcelIgnore
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     * 用名字去匹配，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
     */
    @ExcelProperty(value = "用户名")
    private String username;

    /**
     * 用户密码
     */
    @ExcelProperty(value = "用户密码")
    private String password;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}