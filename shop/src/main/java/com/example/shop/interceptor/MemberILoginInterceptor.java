package com.example.shop.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.shop.annotation.PassToken;
import com.example.shop.common.constants.Member;
import com.example.shop.service.member.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 会登录拦截器
 *
 * @author ZYIMM
 */
@Component
public class MemberILoginInterceptor implements HandlerInterceptor {

    /**
     * 会员
     */
    MemberServiceImpl memberService;

    /**
     * 注入 memberService
     *
     * @param memberService 会员
     */
    @Autowired
    public void setMemberService(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = request.getHeader(Member.TOKEN_KEY);
        if (this.handle(token, o)) {
            return true;
        }
        throw new Exception("token 无效");
    }

    /**
     * 处理
     *
     * @param token  token
     * @param object 控制器方法
     * @return boolean
     */
    private boolean handle(String token, Object object) {
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //有无token 注解
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (!passToken.required()) {
                return true;
            }
        }
        // 获取 token 中的 user id
        String memberId;
        try {
            memberId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException(j.getMessage());
        }
        com.example.shop.entity.Member member = memberService.findById(Integer.parseInt(memberId));
        if (member == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        try {
            // 验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(member.getPwd())).build();
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("401");
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) {
        //todo 验证完毕的操作

    }


}
