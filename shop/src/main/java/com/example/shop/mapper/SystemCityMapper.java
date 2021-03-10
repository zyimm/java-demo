package com.example.shop.mapper;

import com.example.shop.entity.SystemCity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SystemCityMapper {
    public List<SystemCity> listCity();
}
