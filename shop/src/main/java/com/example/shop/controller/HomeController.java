package com.example.shop.controller;

import cn.hutool.db.Db;
import com.example.shop.annotation.PassToken;
import com.example.shop.common.Result;
import com.example.shop.entity.Member;
import com.example.shop.entity.SystemCity;
import com.example.shop.service.member.impl.MemberServiceImpl;
import com.example.shop.service.system.impl.SystemCityServiceImpl;
import com.example.shop.util.CustomIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
    CustomIdGenerator idGenerator;

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
        return Result.success(map);
    }

    @GetMapping("/system/city")
    @PassToken(required = false)
    public Result city(){
        List<SystemCity> cityList = systemCityService.listCity();
        Map<String, Object> map = new HashMap<>();
        map.put("list",  cityList);
        return Result.success(map);
    }

    @GetMapping("/test/uid")
    @PassToken(required = false)
    public Result testUId(){
        return Result.success(idGenerator.nextId(systemCityService));
    }

    //
    @GetMapping("/test/sql")
    @PassToken(required = false)
    public Result sql() throws SQLException {
        return Result.success(Db.use().findAll("eb_user"));
    }

}
