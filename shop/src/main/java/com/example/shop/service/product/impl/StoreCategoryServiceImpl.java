package com.example.shop.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shop.entity.StoreCategory;
import com.example.shop.mapper.StoreCategoryMapper;
import com.example.shop.service.product.StoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Hashtable;
import java.util.Map;

@Component
public class StoreCategoryServiceImpl implements StoreCategoryService {

    StoreCategoryMapper storeCategoryMapper;


    @Autowired
    public void setProductCate(StoreCategoryMapper storeCategoryMapper) {
        this.storeCategoryMapper = storeCategoryMapper;
    }

    /**
     * 获取分类 kv 值
     *
     * @return Map
     */
    public Map<Integer, String> listCategoryKV(){
        Map<Integer, String>  map = new Hashtable<>();
        QueryWrapper<StoreCategory> queryWrapper = new QueryWrapper<>();
        this.storeCategoryMapper.selectList(queryWrapper).forEach(item-> map.put(item.getId(), item.getCateName()));
        return map;
    }

}
