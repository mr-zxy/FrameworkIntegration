package com.common.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Component
@Aspect
public class WyLogAspect {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 其中@Pointcut声明了切点（这里的切点是我们自定义的注解类），
     * @Before声明了通知内容，在具体的通知中，我们通过@annotation(logger)拿到了自定义的注解对象，
     * 所以就能够获取我们在使用注解时赋予的值了。
     */

    @Pointcut("@annotation(com.example.demo.annotation.WyLog)")
    private void pointcut() {}

    @Before("pointcut() && @annotation(logger)")
    public void before(JoinPoint joinPoint, WyLog logger) {
        //类名
        String clsName=joinPoint.getSignature().getDeclaringType().getSimpleName();
        //方法名
        String modName= joinPoint.getSignature().getName();
        //参数
        Object[] args = joinPoint.getArgs();
        StringBuffer result = new StringBuffer();
        System.out.println(logger.value());
        result.append("["+clsName+"]");
        result.append("["+modName+"]");
        Arrays.stream(args).forEach(arg->{
            try {
                result.append("["+OBJECT_MAPPER.writeValueAsString(arg)+"]");
            } catch (JsonProcessingException e) {

            }
        });
        System.out.println(result.toString());
    }
}
