package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "semester")
@Data
public class Semester implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //开始学年
    private Integer startYear;
    //结束学年
    private Integer endYear;
    //是否上学期(start_year下半年)
    private Integer isFirst;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}