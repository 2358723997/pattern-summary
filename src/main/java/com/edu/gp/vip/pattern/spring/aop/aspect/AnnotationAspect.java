package com.edu.gp.vip.pattern.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.validator.constraints.Mod11Check;
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
public class AnnotationAspect {

    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.edu.gp.vip.pattern.spring.aop.service..*(..))")
    public void aspect() {

    }

    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     * @param joinPoint
     */
    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        log.info("before 通知"+joinPoint);
    }

    /**
     * 配置后置通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     */
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        log.info("after 通知"+joinPoint);
    }

    /**
     * 配置后置返回通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     */
    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        log.info("afterReturn 通知"+joinPoint);
    }

    /**
     * 配置抛出异常后通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut = "aspect()",throwing = "ex")
    public void afterThrow(JoinPoint joinPoint,Exception ex){
        log.info("afterThrow 通知,JoinPoint={},Exception={}",joinPoint,ex.getMessage());
    }

    /**
     * 配置环绕通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     */
    @Around("aspect()")
    public void around(JoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint)joinPoint).proceed();
            long end = System.currentTimeMillis();
            log.info("around 通知 : JoinPoint={}, invoke time={}ms",joinPoint,(end-start));
        }catch (Throwable e){
            long end = System.currentTimeMillis();
            log.info("around 通知 : JoinPoint={}, invoke time={}ms, Exception={}",joinPoint,(end-start),e.getMessage());
        }
        log.info("around 通知"+joinPoint);
    }

}
