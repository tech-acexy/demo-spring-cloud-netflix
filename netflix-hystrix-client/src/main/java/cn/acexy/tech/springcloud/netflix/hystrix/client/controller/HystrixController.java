package cn.acexy.tech.springcloud.netflix.hystrix.client.controller;

import cn.acexy.tech.springcloud.netflix.hystrix.client.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hystrix")
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @GetMapping(value = "call-eureka-client")
    String callEurekaClient() {
        return hystrixService.callEurekaClient();
    }
}
