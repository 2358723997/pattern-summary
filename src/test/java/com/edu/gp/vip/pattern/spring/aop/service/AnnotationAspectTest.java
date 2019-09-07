package com.edu.gp.vip.pattern.spring.aop.service;

import com.edu.gp.vip.pattern.spring.aop.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Tom.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationAspectTest {

    @Autowired
    MemberService memberService;

    @Test
    public void testGet(){
        memberService.get();
    }

    @Test
    public void testDelete() throws Exception {
        memberService.delete(0L);
    }
}
