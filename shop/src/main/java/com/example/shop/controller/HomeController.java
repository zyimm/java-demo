package com.example.shop.controller;

import com.example.shop.annotation.PassToken;
import com.example.shop.common.Result;
import com.example.shop.entity.Member;
import com.example.shop.service.member.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
}
