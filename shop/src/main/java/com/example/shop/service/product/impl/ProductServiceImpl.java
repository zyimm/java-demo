package com.example.shop.service.product.impl;


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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class ProductServiceImpl implements ProductService {

    ProductMapper productMapper;

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
     * @param request 请求
     * @param pageParam 分页
     * @return ListVO
     */
    public ListVO<List<Product>>  listProduct(ProductRequest request, PageParamRequest pageParam){
        this.queryWrapper = new QueryWrapper<>();
        IPage<Product> page = new Page<>(pageParam.getPage(), pageParam.getLimit());
        if(request.getStoreInfo() !=null && !request.getStoreInfo().isEmpty()){
            this.queryWrapper.likeRight("store_info", request.getStoreInfo());
        }
        this.queryWrapper.orderByDesc("id");
        IPage<Product> listProduct =  this.productMapper.selectPage(page, queryWrapper);
        return this.productListVo.out(
                listProduct.getRecords(),
                listProduct.getTotal(),
                pageParam.getPage(),
                pageParam.getLimit()
        );
    }

    /**
     * 详细
     *
     * @param id 商品id
     * @return Product
     */
    public Product getProductDetail(Integer id) throws Exception {
        Product result = this.productMapper.selectById(id);
        if(result != null){
            //获取分类
            result.setCategory(this.cateService.listCategory(id));
            return result;
        } else {
            throw new Exception("商品不存在");
        }
    }
}
