package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: TORTUR
 * @description: 通知实体类
 * @author: ZhangQingMin
 * @create: 2021-12-21 14:22
 **/
@TableName(value = "notification")
@Data
public class Notification implements Serializable {

    private Integer id;

    private Integer classId;

    private Integer tutorId;

    private Integer studentId;

    /**
     * 通知内容
     */
    private String notification;

    /**
     * 添加时间
     */
    private Date time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
