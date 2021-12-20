package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "teacher")
@Data
public class Teacher implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;
    //1:男;0:女
    private Integer sex;

    private Integer collegeId;
    //1 显示 0 已删除，提醒设计者应添加定期清除数据机制以免出现数据冗余
    private Integer deleted;

    private Date deleteTime;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
