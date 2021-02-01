package com.example.shop.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;


@Data
@TableName("eb_store_product")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product {
    @TableId
    private Integer id;

    private Integer merId;

    private Integer hooId;

    private Integer distributeId;

    private Integer isHoo;

    private String image;

    private String sliderImage;

    private String storeName;

    private String storeInfo;

    private String keyword;

    private String barCode;

    private String cateId;

    @TableField(numericScale="2")
    private Double price;

    @TableField(numericScale="2")
    private Double cost;

    private String unitName;


    private Integer sort;

    private Integer sales;

    private Integer stock;
    
    private Integer isShow;

    private Integer addTime;

    private Integer specType;

    public String getAddTime() {
        return "";

    }
}
