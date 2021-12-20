package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "reply")
@Data
public class Reply implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //评论表中的信息id
    private Integer appriseId;
    //回复id
    private Integer answererId;
    //回复类型,Tutor,Student
    private Integer answererType;
    //回复信息内容
    private String content;

    private Integer received;

    private Integer completed;

    private Date replyTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
