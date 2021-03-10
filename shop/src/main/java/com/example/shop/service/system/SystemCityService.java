package com.example.shop.service.system;

import com.example.shop.entity.SystemCity;
import com.example.shop.service.BaseService;

import java.util.List;

public interface SystemCityService  extends BaseService {
    public List<SystemCity> listCity();
}
