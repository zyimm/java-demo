package com.example.shop.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.example.shop.common.constants.Common;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Data
@TableName(value = "eb_store_product", autoResultMap = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product implements Serializable {

    @TableId
    private Integer id;

    private Integer merId;

    private Integer hooId;

    private Integer distributeId;

    private Integer isHoo;

    private String image;

    /**
     * 类型处理
     *
     * @deprecated https://www.hangge.com/blog/cache/detail_2926.html
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<String> sliderImage;

    private String storeName;

    private String storeInfo;

    private String keyword;

    private String barCode;

    private Integer cateId;

    @TableField(numericScale = "2")
    private BigDecimal price;

    @TableField(numericScale = "2")
    private BigDecimal cost;

    private String unitName;

    private Integer sort;

    private Integer sales;

    private Integer stock;

    private Integer isShow;

    private Integer addTime;

    private Integer specType;

    @TableField(exist = false)
    private List<ProductCate> category;

    /**
     * 时间处理
     *
     * @return String
     */
    public String getAddTime() {
        Long addTimeL = Long.valueOf(addTime);
        Date date = new Date(addTimeL * 1000);
        SimpleDateFormat formatter = new SimpleDateFormat(Common.DATE_FORMAT);
        return formatter.format(date);
    }
}
