package com.example.shop.service.system.impl;

import com.example.shop.entity.SystemCity;
import com.example.shop.mapper.SystemCityMapper;
import com.example.shop.service.system.SystemCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemCityServiceImpl implements SystemCityService {

    @Autowired
    SystemCityMapper systemCityMapper;

    @Override
    public List<SystemCity> listCity(){
        return systemCityMapper.listCity();
    }
}


