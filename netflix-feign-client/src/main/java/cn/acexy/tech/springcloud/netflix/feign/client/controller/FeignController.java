package cn.acexy.tech.springcloud.netflix.feign.client.controller;

import cn.acexy.tech.springcloud.netflix.feign.client.service.EurekaUserService;
import cn.acexy.tech.springcloud.netflix.feign.client.service.FeignUserService;
import cn.acexy.tech.springcloud.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间 : 2021/4/19 <br />
 *
 * @author : acexy@acexy.cn
 **/
@RestController
@RequestMapping(value = "feign")
public class FeignController {

    @Autowired
    EurekaUserService eurekaUserService;

    @Autowired
    FeignUserService feignUserService;

    @GetMapping(value = "get-from-eureka")
    User getFromEureka() {
        return eurekaUserService.get();
    }

    @GetMapping(value = "get-by-name-from-eureka")
    User getByNameFromEureka(@RequestParam(name = "name") String name) {
        return eurekaUserService.getByName(name);
    }

    @GetMapping(value = "get-from-feign")
    User getFromFeign() {
        return feignUserService.get();
    }
}