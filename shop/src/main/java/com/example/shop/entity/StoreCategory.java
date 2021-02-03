package com.example.shop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@TableName(value = "eb_store_category")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StoreCategory {
    @TableId
    private Integer id;

    private Integer pid;

    private String cateName;

    private Integer sort;

    private String pic;

    private Integer isShow;

}
