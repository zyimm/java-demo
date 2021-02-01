package com.example.shop.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shop.entity.Product;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.service.product.ProductService;
import com.example.shop.vo.ListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductServiceImpl implements ProductService {

    ProductMapper productMapper;


    @Autowired
    public void setProduct(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product getProductInfoById(Integer id) {
        return  this.productMapper.selectById(id);
    }

    public ListVO  listProduct(){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        IPage<Product> page = new Page<>(1L, 20L);
        IPage<Product> listProduct =  this.productMapper.selectPage(page, queryWrapper);
        return new ListVO(
                listProduct.getRecords(),
                listProduct.getTotal(),
                1L,
                10L
        );
    }
}
