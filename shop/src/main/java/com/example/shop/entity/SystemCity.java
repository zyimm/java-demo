package com.example.shop.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SystemCity {

    private Integer id;

    private Integer cityId;

    private Integer level;

    private Integer parentId;

    private String areaCode;

    private String name;

    private String mergerName;

    private String lng;

    private String lat;

    private Integer isShow;

    public String getMergerName() {
        if (this.mergerName == null) {
            return "";
        } else {
            return this.mergerName;
        }
    }
}
