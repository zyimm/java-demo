package com.example.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@TableName("eb_user")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Member {

    @TableId(value = "uid",type = IdType.AUTO)//指定主键名及自增
    private Long uid;

    private String account;

    private Integer status;

    private String pwd;

    private String realName;

    private String birthday;

    private String cardId;

    private String mark;

    private Integer partnerId;

    private Integer groupId;

    private String nickname;

    private String avatar;

    private String phone;

    private String addTime;

    private String addIp;

    private String lastTime;

    private String lastIp;

    private Float nowMoney;

    private Float brokeragePrice;

    private Float integral;

    private Float exp;

    private Integer signNum;

    private String level;

    private String spreadUid;

    private String spreadTime;

    private String userType;

    private Byte isPromoter;

    private Integer payCount;

    private Integer spreadCount;

    private String cleanTime;

    private String addres;

    private Integer adminid;

    private String loginType;

}
