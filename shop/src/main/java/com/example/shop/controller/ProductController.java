package com.example.shop.controller;

import com.example.shop.annotation.PassToken;
import com.example.shop.common.Result;
import com.example.shop.controller.request.ProductRequest;
import com.example.shop.service.product.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 *
 * @author ZYIMM
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    public ProductServiceImpl productService;

    @Autowired
    public void setProductService(ProductServiceImpl productService){
        this.productService = productService;
    }

    @GetMapping("list")
    @PassToken(required = false)
    public Object productList(ProductRequest request){
        return Result.success(this.productService.listProduct(request));
    }

    @GetMapping("detail/{id}")
    @PassToken(required = false)
    public Object productDetail(@PathVariable Integer id){
        return Result.success(this.productService.getProductInfoById(id));
    }
}
