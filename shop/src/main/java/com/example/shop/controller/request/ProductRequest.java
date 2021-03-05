package com.example.shop.controller.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;


@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductRequest implements Serializable {

    private String storeInfo;

    private Integer isHoo;

    private Object data;

}
