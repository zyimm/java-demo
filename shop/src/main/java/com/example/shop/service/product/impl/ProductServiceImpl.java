package com.example.shop.service.product.impl;

import com.example.shop.entity.Product;
import com.example.shop.service.product.ProductService;

public class ProductServiceImpl implements ProductService {

    Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public Object getProductInfoById(Integer id) {
        this.product.s;
    }
}
