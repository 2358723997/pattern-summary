package com.edu.gp.vip.pattern.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ArgsAspect类
 *
 * @author wangjixue
 * @date 2019-09-07 15:43
 */
//声明这是一个组件
@Component
//声明这是一个切面Bean
@Aspect
@Slf4j
public class ArgsAspect {

    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.edu.gp.vip.pattern.spring.aop.service..*(..))")
    public void aspect() {

    }

    //配置前置通知,拦截返回值为cn.ysh.studio.spring.mvc.bean.User的方法
    @Before("execution(com.edu.gp.vip.pattern.spring.aop..domain.Member com.edu.gp.vip.pattern.spring.aop.service..*(..))")
    public void beforeReturnUser(JoinPoint joinPoint){
        log.info("beforeReturnUser, JoinPoint={}",joinPoint);
    }

    //配置前置通知,拦截参数为cn.ysh.studio.spring.mvc.bean.User的方法
    @Before("execution(* com.edu.gp.vip.pattern.spring.aop.service..*(com.edu.gp.vip.pattern.spring.aop..domain.Member))")
    public void beforeArgUser(JoinPoint joinPoint){
        log.info("beforeArgUser, JoinPoint={}",joinPoint);

    }

    //配置前置通知,拦截含有long类型参数的方法,并将参数值注入到当前方法的形参id中
    @Before("aspect()&&args(id)")
    public void beforeArgId(JoinPoint point,Long id){
        StringBuilder builder = new StringBuilder();
        builder.append("beforeArgId").append(point).append("\t").append("ID:").append(id);
        log.info(builder.toString());
    }
}
