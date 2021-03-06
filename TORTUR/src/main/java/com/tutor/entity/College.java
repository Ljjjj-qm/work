package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "college")
@Data
public class College implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //学校名称
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}