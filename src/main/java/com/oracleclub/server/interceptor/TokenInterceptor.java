package com.oracleclub.server.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截器，拦截所有请求
 * 放行未被controller捕获的请求和含有PassToken注解的请求
 * @author RETURN
 * @date 2020/8/13 22:26
 */
@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    private static final String TOKEN_NAME = "token";

    @Resource(name = "tokenCache")
    private Cache<String, String> tokenCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (CorsUtils.isPreFlightRequest(request)) {
//            return true;
//        }
//        //如果该url没有进入controller的方法
//        if (!(handler instanceof HandlerMethod)){
//            return true;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//
//        if(handlerMethod.getBeanType() == BasicErrorController.class){
//            throw new RuntimeException("未知错误");
//        }
//        //如果有不需要验证token的注解
//        if (handlerMethod.hasMethodAnnotation(PassToken.class)){
//            return true;
//        }
//
//        String token = request.getHeader(TOKEN_NAME);
//        if (null == token){
//            throw new AuthenticationException("无token,请重新登录");
//        }
//        //验证token
//        Map<String, Claim> verify = JwtUtil.verify(token);
//        String userId = verify.get("userId").asString();
//        String cacheToken = tokenCache.get(userId);
//        if (!token.equals(cacheToken)){
//            throw new AuthenticationException("token已失效,请重新登录");
//        }
//        log.info("token验证通过");
//        request.setAttribute("userId",userId);
        return true;
    }
}
