package com.itheima.gatewayadmin.filter;


import com.itheima.common.constants.SystemConstants;
import com.itheima.common.util.AppJwtUtil;
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

@Slf4j
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1对登录请求放行，非登录判断是否登录过校验token
        //2解析token成功放行，失败返回401

        //1获取请求对象，响应对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        //2获取请求路径
        String path = request.getURI().getPath();
        log.debug("请求的地址：{}", path);
        //3判断路径是否为登录路径
        if (path.startsWith("/admin/login")) {

            return chain.filter(exchange);
        }
        //4获取请求头中的token
        String token = request.getHeaders().getFirst("token");
        if (!StringUtils.isEmpty(token)) {
            //5解析token
            if (AppJwtUtil.verifyToken(token) == SystemConstants.JWT_OK) {
                //6成功贼放行
                return chain.filter(exchange);
            }

        }


        //7拦截并返回
        response.setStatusCode(HttpStatus.BAD_REQUEST);
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
