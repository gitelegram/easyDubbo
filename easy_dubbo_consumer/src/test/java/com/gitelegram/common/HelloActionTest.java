package com.gitelegram.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dubbo.xml"})
public class HelloActionTest {

    @Autowired
    private HelloAction helloAction;
    @Test
    public void testSayHello() throws Exception {
        String result=helloAction.sayHello("kelly.li");
        System.out.println(result);
    }
}
