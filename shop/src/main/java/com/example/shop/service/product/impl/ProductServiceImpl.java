package com.example.shop.service.product.impl;


import cn.hutool.core.text.StrSpliter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shop.controller.request.PageParamRequest;
import com.example.shop.controller.request.ProductRequest;
import com.example.shop.entity.Product;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.service.product.ProductService;
import com.example.shop.vo.ListVO;
import com.example.shop.vo.product.ProductListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Slf4j
public class ProductServiceImpl implements ProductService {

    ProductMapper productMapper;

    ProductRequest request;

    ProductCateServiceImpl cateService;

    QueryWrapper<Product> queryWrapper;

    @Autowired
    ProductListVo productListVo;


    @Autowired
    public void setProduct(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Autowired
    public void setCateService(ProductCateServiceImpl cateService) {
        this.cateService = cateService;
    }

    /**
     * 列表
     *
     * @param request   请求
     * @param pageParam 分页
     * @return ListVO
     */
    public ListVO<List<Product>> listProduct(ProductRequest request, PageParamRequest pageParam) {
        this.queryWrapper = new QueryWrapper<>();
        this.request = request;
        IPage<Product> page = new Page<>(pageParam.getPage(), pageParam.getLimit());
        if (request.getStoreInfo() != null && !request.getStoreInfo().isEmpty()) {
            //this.queryWrapper.likeRight("store_info", request.getStoreInfo());
            this.buildQuery(this.condition());
        }

        this.queryWrapper.orderByDesc("id");
        IPage<Product> listProduct = this.productMapper.selectPage(page, queryWrapper);
        this.queryWrapper = null;
        this.request = null;
        return this.productListVo.out(
                listProduct.getRecords(),
                listProduct.getTotal(),
                pageParam.getPage(),
                pageParam.getLimit()
        );
    }

    /**
     * 构建query
     *
     *
     * @param map 查询map
     */
    public void buildQuery(Map<String, String> map) {
        map.forEach((key, val) -> {
            try {
                List<String> methodArray = StrSpliter.split(val, '@', 0, true, true);
                Method m = this.queryWrapper.getClass().
                        getMethod(key, Object.class, Object.class);
                //
                Method requestMethod = this.request.getClass().
                        getMethod(methodArray.get(1));
                Type ReturnType = requestMethod.getReturnType();
                //
                Object requestVal = requestMethod.invoke(this.request);

                Object requestValue = null;
                String typeName = ReturnType.getTypeName();
                log.info(typeName);
                switch (typeName) {
                    case "java.lang.String":
                        requestValue = String.valueOf(requestVal);
                        break;
                    case "java.lang.Integer":
                        requestValue = requestVal;
                        break;
                }
                if (requestValue != null) {
                    m.invoke(this.queryWrapper, methodArray.get(0), requestValue);
                }

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * 查询配置
     *
     * @return map
     */
    public Map<String, String> condition() {
        Map<String, String> map = new HashMap<>();
        map.put("likeRight", "store_info@getStoreInfo");
        map.put("eq", "is_hoo@getIsHoo");
        return map;
    }

    /**
     * 详细
     *
     * @param id 商品id
     * @return Product
     */
    public Product getProductDetail(Integer id) throws Exception {
        Product result = this.productMapper.selectById(id);
        if (result != null) {
            //获取分类
            result.setCategory(this.cateService.listCategory(id));
            return result;
        } else {
            throw new Exception("商品不存在");
        }
    }
}
