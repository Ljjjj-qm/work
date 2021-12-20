package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "tutor")
@Data
public class Tutor implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;
    //1:男;0:女
    private Integer sex;

    private Integer teacherId;

    private Integer classId;

    private Integer semesterId;
    //接手日期
    private Date startDate;
    //交接日期
    private Date endDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
