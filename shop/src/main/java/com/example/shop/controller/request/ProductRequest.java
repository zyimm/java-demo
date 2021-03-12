package com.example.shop.controller.request;

import lombok.Data;

import java.io.Serializable;


@Data
public class ProductRequest implements Serializable {

    private String storeInfo;

    private Integer isHoo;

    private Object data;

}
