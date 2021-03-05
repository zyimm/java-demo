package com.example.shop.vo.product;


import com.example.shop.entity.Product;
import com.example.shop.service.product.impl.ProductCateServiceImpl;
import com.example.shop.vo.ListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductListVo  {

    @Autowired
    public ProductCateServiceImpl productCateService;

    public ListVO<List<Product>> out(List<Product> list, long totalCount, long page, long pageLimit) {
        list.forEach( item -> item.setCategory(productCateService.listCategory(item.getId())) );
        return new ListVO<>(list, totalCount, page, pageLimit);
    }
}
