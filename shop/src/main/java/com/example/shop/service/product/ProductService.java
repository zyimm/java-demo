package com.example.shop.service.product;

import com.example.shop.entity.Product;
import com.example.shop.service.BaseService;

public interface ProductService extends BaseService {

    Product getProductDetail(Integer id) throws Exception;

}
