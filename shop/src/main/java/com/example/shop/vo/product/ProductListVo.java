package com.example.shop.vo.product;


import com.example.shop.entity.Product;
import com.example.shop.entity.ProductCate;
import com.example.shop.service.product.impl.ProductCateServiceImpl;
import com.example.shop.vo.ListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProductListVo {

    @Autowired
    public ProductCateServiceImpl productCateService;

    private List<Product> list;

    /**
     * 输出
     *
     * @param list       数据
     * @param totalCount 数量
     * @param page       当页码
     * @param pageLimit  分页大小
     * @return ListVO
     */
    public ListVO<List<Product>> out(List<Product> list, long totalCount, long page, long pageLimit) {
        this.list = list;
        this.setCategory();
        return new ListVO<>(this.list, totalCount, page, pageLimit);
    }

    /**
     * 关联分类
     *
     */
    protected void setCategory() {
        List<Integer> productIds = new ArrayList<>();
        this.list.forEach(item -> productIds.add(item.getId()));
        Map<Integer, List<ProductCate>> map = productCateService.getCategoryMap(productIds);
        this.list.forEach(item -> item.setCategory(productCateService.listCategory(item.getId(), map)));
    }
}
