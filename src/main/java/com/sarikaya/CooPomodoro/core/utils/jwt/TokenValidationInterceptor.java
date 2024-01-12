package com.sarikaya.CooPomodoro.core.utils.jwt;

import com.sarikaya.CooPomodoro.core.utils.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

@Component
@Aspect
public class TokenValidationInterceptor {
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public TokenValidationInterceptor(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Around("@annotation(com.sarikaya.CooPomodoro.core.utils.jwt.TokenValidation)")
    public Object validateToken(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        if (method.isAnnotationPresent(TokenValidation.class)) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            String accessToken = request.getHeader("Authorization");

            if (accessToken != null && accessToken.startsWith("Bearer ")) {
                String token = accessToken.replace("Bearer ", "");
                if (!jwtTokenUtil.isTokenValid(token)) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                            .body(new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), null, "Unauthorized!"));
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), null, "Unauthorized!"));
            }
        }

        return joinPoint.proceed();
    }
}
