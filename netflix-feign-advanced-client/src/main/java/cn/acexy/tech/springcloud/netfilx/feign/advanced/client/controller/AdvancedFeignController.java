package cn.acexy.tech.springcloud.netfilx.feign.advanced.client.controller;

import cn.acexy.tech.springcloud.netfilx.feign.advanced.client.service.AdvancedUserService;
import cn.acexy.tech.springcoud.common.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "adv-feign")
public class AdvancedFeignController implements AdvancedUserService {

    public User getUser() {
        return null;
    }

    public User getUserByName(String name) {
        return null;
    }
}
