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

    @GetMapping(value = "get-user")
    User getUser() {
        return eurekaUserService.getUser();
    }

    @GetMapping(value = "get-user-by-name")
    User getUserByName(@RequestParam(name = "name") String name) {
        return eurekaUserService.getUserByName(name);
    }

    @GetMapping(value = "get-user-from-feign")
    User getUserFromFeign() {
        return feignUserService.getUser();
    }
}