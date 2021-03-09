package com.example.shop.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shop.entity.ProductCate;
import com.example.shop.mapper.ProductCateMapper;
import com.example.shop.service.product.ProductCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductCateServiceImpl implements ProductCateService {


    ProductCateMapper productCateMapper;

    StoreCategoryServiceImpl storeCategoryService;

    @Autowired
    public void setProductCate(ProductCateMapper productCateMapper) {
        this.productCateMapper = productCateMapper;
    }

    @Autowired
    public void setStoreCategoryService(StoreCategoryServiceImpl storeCategoryService) {
        this.storeCategoryService = storeCategoryService;
    }

    /**
     * 获取关联栏目
     *
     * @param productId 商品id
     * @return List
     */
    public List<ProductCate> listCategory(Integer productId) {
        Map<String, Object> map = new HashMap<>();
        map.put("product_id", productId);
        List<ProductCate> results = this.productCateMapper.selectByMap(map);
        Map<Integer, String> categoryMap = this.listCategoryKV();
        if (results != null && !results.isEmpty()) {
            results.forEach(result -> result.setCategoryName(categoryMap.get(result.getCateId())));
        }
        return results;
    }

    /**
     * 获取关联栏目-列表用
     *
     * @param productId 商品id
     * @param map       分类map
     * @return List<ProductCate>
     */
    public List<ProductCate> listCategory(Integer productId, Map<Integer, List<ProductCate>> map) {
        return map.get(productId);
    }

    /**
     * 批量获取商品分类Map
     *
     * @param productIds 商品id
     * @return map
     */
    public Map<Integer, List<ProductCate>> getCategoryMap(List<Integer> productIds) {
        Map<Integer, List<ProductCate>> map = new ConcurrentHashMap<>();
        Map<Integer, String> categoryName = this.listCategoryKV();
        QueryWrapper<ProductCate> queryWrapper = new QueryWrapper<>();
        List<ProductCate> results = this.productCateMapper.selectList(queryWrapper);
        for (Integer productId : productIds) {
            List<ProductCate> productCateList = new ArrayList<>();
            for (ProductCate category : results) {
                if (category.getProductId().equals(productId)) {
                    category.setCategoryName(categoryName.get(category.getCateId()));
                    productCateList.add(category);
                }
            }
            map.put(productId, productCateList);
        }
        return map;
    }


    /**
     * 获取栏目kv 数据
     *
     * @return map
     */
    private Map<Integer, String> listCategoryKV() {
        return this.storeCategoryService.listCategoryKV();
    }
}
