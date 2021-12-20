package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "student")
@Data
public class Student implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String name;

    private Integer age;
    //1:男；0:女
    private Integer sex;
    //学生的辅导员id
    private Integer tutorId;

    private Integer classId;

    //删除(逻辑删除)
    private Integer deleted;

    private Integer deleteTime;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
