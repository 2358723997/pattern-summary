package com.edu.gp.vip.pattern.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ArgsAspect类
 *
 * @author wangjixue
 * @date 2019-09-07 15:43
 */
@Slf4j
public class XmlAspect {

    /**
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     * @param joinPoint
     */
    public void before(JoinPoint joinPoint){
        log.info("实例参数列表={}",joinPoint.getArgs());
        //连接点类型，如method-execution
        log.info("连接点类型={}",joinPoint.getKind());
        log.info("被调用的切点={}",joinPoint.getSignature());
        log.info("目标对象={}",joinPoint.getTarget());
        log.info("连接点信息={}",joinPoint.getThis());
        log.info("before 通知"+joinPoint);
    }

    /**
     * 配置后置通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     */
    public void after(JoinPoint joinPoint){
        log.info("after 通知"+joinPoint);
    }

    /**
     * 配置后置返回通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     */
    public void afterReturn(JoinPoint joinPoint){
        log.info("afterReturn 通知"+joinPoint);
    }

    /**
     * 配置抛出异常后通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     * @param ex
     */
    public void afterThrow(JoinPoint joinPoint,Exception ex){
        log.info("afterThrow 通知,JoinPoint={},Exception={}",joinPoint,ex.getMessage());
    }

    /**
     * 配置环绕通知,使用在方法aspect()上注册的切入点
     * @param joinPoint
     */
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
