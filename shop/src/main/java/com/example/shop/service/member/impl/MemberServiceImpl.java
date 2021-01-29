package com.example.shop.service.member.impl;

import com.example.shop.entity.Member;
import com.example.shop.mapper.MemberMapper;
import com.example.shop.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    MemberMapper memberMapper;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }

    public Member findById(int id){
        return this.memberMapper.selectById(id);
    }

    public int updateById(Member member){
        return memberMapper.updateById(member);
    }
}
