package com.imooc.ecommerce.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NacosClientService {

    private final DiscoveryClient discoveryClient;

    // 使用构造函数的方式进行注入，相等于 @Autowire
    public NacosClientService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    /**
     * <h2>打印 Nacos client 信息到日志中</h2>
     */
    public List<ServiceInstance> getNacosClientInfo(String serviceId) {
        log.info("request nacos client to get service instance info: [{}]", serviceId);
        return discoveryClient.getInstances(serviceId);
    }

}
