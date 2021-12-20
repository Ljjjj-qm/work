package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "clazz")
@Data
public class Clazz implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //课程，例如Java
    private String code;
    //所属学院
    private Integer collegeId;
    //入学时间
    private Integer enterYear;
    //0:专科;1:本科;2:专升本;3:中专
    private Integer classType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}