package cn.acexy.tech.springcloud.netfilx.feign.advanced.client.controller;

import cn.acexy.tech.springcloud.netfilx.feign.advanced.client.service.AdvancedUserService;
import cn.acexy.tech.springcloud.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "advanced-feign-user")
public class AdvancedFeignUserController {

    @Autowired
    private AdvancedUserService advancedUserService;

    @GetMapping(value = "get-user")
    public User getUser() {
        return advancedUserService.get();
    }

    @GetMapping(value = "get-user-by-name")
    public User getUserByName(@RequestParam(name = "name") String name) {
        return advancedUserService.getByName(name);
    }
}
