package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//role表
@TableName(value = "role")
@Data
public class Role implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    //关联的表
    private String tableName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
