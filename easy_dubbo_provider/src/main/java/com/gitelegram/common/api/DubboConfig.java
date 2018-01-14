package com.gitelegram.common.api;

import com.alibaba.dubbo.config.*;

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

        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", 20800);

        ProviderConfig providerConfig = new ProviderConfig();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("qloglevel", "9");
        protocolConfig.setParameters(parameters);

        HelloService helloService = new HelloServiceImpl();

        ServiceConfig<HelloService> serviceConfig = new ServiceConfig<HelloService>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setProvider(providerConfig);
        serviceConfig.setInterface(HelloService.class);
        serviceConfig.setRef(helloService);
        serviceConfig.setVersion("1.0-SNAPSHOT");
        serviceConfig.setTimeout(3000);
        serviceConfig.export();
    }
}
