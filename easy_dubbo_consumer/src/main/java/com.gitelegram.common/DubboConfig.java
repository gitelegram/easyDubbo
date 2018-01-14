package com.gitelegram.common;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.gitelegram.common.api.HelloService;

import java.util.HashMap;
import java.util.Map;

public class DubboConfig {

    public void init(){
        ApplicationConfig applicationConfig = new ApplicationConfig("spring-dubbo.xml");
        applicationConfig.setOwner("michael");
        applicationConfig.setOrganization("gitelegram");

        RegistryConfig registryConfig = new RegistryConfig("zkAddress");
        registryConfig.setProtocol("zookeeper");
        registryConfig.setGroup("/gitelegram/demo");

        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("qaccesslog", "9");
        consumerConfig.setParameters(parameters);

        ReferenceConfig<HelloService> referenceConfig = new ReferenceConfig<HelloService>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setConsumer(consumerConfig);
        referenceConfig.setInterface(HelloService.class);
        referenceConfig.setVersion("1.0-SNAPSHOT");
        referenceConfig.setCheck(false);
        HelloService helloService = referenceConfig.get();

    }
}
