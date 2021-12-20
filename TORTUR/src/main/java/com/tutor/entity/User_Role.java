package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//user_role表
@TableName(value = "user_role")
@Data
public class User_Role implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer roleId;

    //role关联的用户表中的ID：如果是null，那么表示该表中所有的用户
    private Integer userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
