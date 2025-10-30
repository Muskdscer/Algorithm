//package com.example.jwt;
//
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Component
//public class JwtAuthFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
//        if (token == null || !token.startsWith("Bearer ")) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
//        try {
//            String jwtToken = token.substring(7);//去掉"Bearer "前缀
//            List<String> roles = JwtValidator.getRoles(jwtToken);
//            //检查角色是否匹配(示例：仅允许ROLE_ADMIN 访问)
//            if (!roles.contains("ROLE_ADMIN")) {
//                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//                return exchange.getResponse().setComplete();
//            }
//        } catch (JWTVerificationException e) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;//优先级
//    }
//}
