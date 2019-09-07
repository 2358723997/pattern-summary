package com.edu.gp.vip.pattern.spring.aop.service;

import com.edu.gp.vip.pattern.spring.aop.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * MemberService类
 *
 * @author wangjixue
 * @date 2019-09-07 15:03
 */
@Service
public class MemberService {
    public static final Logger logger = LoggerFactory.getLogger(MemberService.class);


   public Member get(Long id){
       logger.info("invoke method get member , request={}",String.valueOf(id));
        return new Member();
    }

    public Member get(){
        logger.info("invoke method get member ");
        return new Member();
    }

    public void save(Member member){
       logger.info("invoke method save member");
    }

    public void delete(Long id) throws Exception {
       logger.info("invoke method delete member");
       throw new Exception("spring aop ThrowAdvice demo");
    }
}
