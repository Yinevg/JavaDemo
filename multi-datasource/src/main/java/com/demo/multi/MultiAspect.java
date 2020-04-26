package com.demo.multi;

import org.apache.ibatis.binding.MapperProxy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by Yinevg on 2020/4/26
 */
@Aspect
public class MultiAspect {

    @Before("execution(* *..*Dao*.*(*,..))")
    public void before(JoinPoint joinPoint) {
        try {
            // 获取代理类MapperProxy
            Field h = joinPoint.getTarget().getClass().getSuperclass().getDeclaredField("h");
            h.setAccessible(true);
            MapperProxy mapperProxy = (MapperProxy) h.get(joinPoint.getTarget());
            // 获取被代理类，即mapperProxy的mapperInterface字段
            Field mapperInterface = mapperProxy.getClass().getDeclaredField("mapperInterface");
            mapperInterface.setAccessible(true);
            Class<?> clazz = (Class<?>) mapperInterface.get(mapperProxy);
            DataSourceStrategy dataSourceStrategy = clazz.getAnnotation(DataSourceStrategy.class);
            if (Objects.nonNull(dataSourceStrategy) && !StringUtils.isEmpty(dataSourceStrategy.value())) {
                MultiDataSourceHolder.set(dataSourceStrategy.value());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
