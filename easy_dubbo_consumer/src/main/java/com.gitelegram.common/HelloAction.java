package com.gitelegram.common;

import com.gitelegram.common.api.HelloService;

public class HelloAction {

    private HelloService helloService;

    public HelloService getHelloService() {
        return helloService;
    }

    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
