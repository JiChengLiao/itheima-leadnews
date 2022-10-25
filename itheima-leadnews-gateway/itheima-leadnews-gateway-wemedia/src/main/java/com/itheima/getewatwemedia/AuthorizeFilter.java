package com.itheima.getewatwemedia;

import com.itheima.common.constants.SystemConstants;
import com.itheima.common.util.AppJwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * 网关统一鉴权，判断用户是否登录
 */
@Slf4j
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1登录请求白名单过滤，
        ServerHttpRequest req = exchange.getRequest();
        ServerHttpResponse res = exchange.getResponse();
        //1获取请求对象，响应对象
        //1获取请求路径
        String path = req.getURI().getPath();
        log.info("请求路径：{}", path);
        if (path.startsWith("/wemedia/login")) {

            return chain.filter(exchange);
        }
        //1对请求路径判断是否为登录的路径是则放行
        String token = req.getHeaders().getFirst("token");
        //2获取请求头中的token，校验token的有效性
        if (!StringUtils.isEmpty(token)) {
            int result = 0;
            try {
                //claims载荷
                Claims claims = AppJwtUtil.getClaimsBody(token);
                //获取登录用户的ID
                Long loginUserId = claims.get("id", Long.class);
                req.mutate().header(SystemConstants.USER_HEADER_NAME,loginUserId.toString());
                result= SystemConstants.JWT_OK;
            } catch (ExpiredJwtException ex) {
                result= SystemConstants.JWT_EXPIRE;
            } catch (Exception e) {
                result=SystemConstants.JWT_FAIL;
            }

            if (SystemConstants.JWT_OK == result) {
                return chain.filter(exchange);
            }

        }
        //2.1判断token是否为空


        //3如果有效则放行

        //4无token贼拒绝访问，返回401
        res.setStatusCode(HttpStatus.UNAUTHORIZED);
        return res.setComplete();

    }

    //@Override
    //public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    //    //1登录请求白名单过滤，
    //    ServerHttpRequest req = exchange.getRequest();
    //    ServerHttpResponse res = exchange.getResponse();
    //    //1获取请求对象，响应对象
    //    //1获取请求路径
    //    String path = req.getURI().getPath();
    //    log.info("请求路径：{}", path);
    //    if (path.startsWith("/wemedia/login")) {
    //
    //        return chain.filter(exchange);
    //    }
    //    //1对请求路径判断是否为登录的路径是则放行
    //    String token = req.getHeaders().getFirst("token");
    //    //2获取请求头中的token，校验token的有效性
    //    if (!StringUtils.isEmpty(token)) {
    //        if (SystemConstants.JWT_OK == AppJwtUtil.verifyToken(token)) {
    //            return chain.filter(exchange);
    //        }
    //
    //    }
    //    //2.1判断token是否为空
    //
    //
    //    //3如果有效则放行
    //
    //    //4无token贼拒绝访问，返回401
    //    res.setStatusCode(HttpStatus.UNAUTHORIZED);
    //    return res.setComplete();
    //
    //}

    @Override
    public int getOrder() {
        return 0;
    }
}
