package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//评分表
@TableName(value = "apprise")
@Data
public class Apprise implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer studentId;

    private Integer tutorId;

    //评分1-5
    private Integer score;

    //评价信息
    private String content;

    private Date appriseTime;

    //收到确认
    private Integer received;

    private Integer completed;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}