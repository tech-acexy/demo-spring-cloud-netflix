package cn.acexy.tech.springcloud.netflix.hystrix.client.controller;

import cn.acexy.tech.springcloud.netflix.hystrix.client.service.HystrixUserService;
import cn.acexy.tech.springcoud.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hystrix")
public class HystrixController {

    @Autowired
    private HystrixUserService hystrixUserService;

    @GetMapping(value = "get-user")
    User getUser() {
        return hystrixUserService.getUser();
    }
}
