package com.example.shop.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.common.constants.Common;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@TableName(value = "eb_store_product_cate")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductCate implements Serializable {
    @TableId
    private Integer id;

    private Integer productId;

    private Integer cateId;

    private Integer addTime;

    @TableField(exist = false)
    private String categoryName;

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
