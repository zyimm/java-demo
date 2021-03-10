package com.example.shop.controller;

import com.example.shop.annotation.PassToken;
import com.example.shop.common.Result;
import com.example.shop.entity.Member;
import com.example.shop.entity.SystemCity;
import com.example.shop.service.member.impl.MemberServiceImpl;
import com.example.shop.service.system.SystemCityService;
import com.example.shop.service.system.impl.SystemCityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页
 *
 * @author ZYIMM
 */
@RestController
public class HomeController {
    
    MemberServiceImpl memberService;

    @Autowired
    SystemCityServiceImpl systemCityService;

    @Autowired
    public void setMemberService(MemberServiceImpl memberService){
        this.memberService = memberService;
    }

    @GetMapping("/")
    @PassToken(required = false)
    public Result index(){
        Member member = memberService.findById(6);
        Map<String, Object> map = new HashMap<>();
        map.put("data",  member);
        map.put("test", "zyimm");
        return Result.success(map);
    }

    @GetMapping("/system/city")
    @PassToken(required = false)
    public Result city(){
        List<SystemCity> cityList = systemCityService.listCity();
        Map<String, Object> map = new HashMap<>();
        map.put("data",  cityList);
        return Result.success(map);
    }
}
