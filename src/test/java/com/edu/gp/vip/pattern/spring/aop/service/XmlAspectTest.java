package com.edu.gp.vip.pattern.spring.aop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Tom.
 */

@RunWith(SpringRunner.class)
@SpringBootApplication
@ImportResource(locations = {"classpath*:application-aop.xml"})
public class XmlAspectTest {

    @Autowired
    MemberService memberService;

    @Test
    public void testGet() {
        memberService.get();
    }

    @Test
    public void testDelete() throws Exception {
        memberService.delete(0L);
    }

}
