package cn.acexy.tech.springcloud.netflix.feign.client.controller;

import cn.acexy.tech.springcloud.netflix.feign.client.service.FeignUserService;
import cn.acexy.tech.springcoud.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    FeignUserService feignUserService;

    @RequestMapping(value = "get-user")
    User getUser() {
        return feignUserService.getUser();
    }
}