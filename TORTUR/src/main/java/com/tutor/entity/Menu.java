package com.tutor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "menu")
@Data
public class Menu implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //名称，例如:系统管理，菜单管理
    private String name;
    //级别
    private Integer level;
    //父菜单
    private Integer parent;
    //显示顺序
    private Integer sequence;
    //页面的url
    private String address;
    //平台
    private String platform;
    //图标
    private String icon;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
