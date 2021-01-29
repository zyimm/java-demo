package com.example.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("eb_user")
public class Member {

    @TableId(value = "uid",type = IdType.AUTO)//指定主键名及自增
    private Long uid;

    private String account;

    private String pwd;

    private Integer status;

    private String realName;

    private String loginType;

}
