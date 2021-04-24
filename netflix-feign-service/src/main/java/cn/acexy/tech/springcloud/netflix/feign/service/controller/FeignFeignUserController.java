package cn.acexy.tech.springcloud.netflix.feign.service.controller;

import cn.acexy.tech.springcloud.netflix.feign.service.service.FeignUserService;
import cn.acexy.tech.springcoud.common.bean.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignFeignUserController implements FeignUserService {

    public User getUser() {
        return new User();
    }

    public User getUserByName(String name) {
        return new User(name);
    }
}
