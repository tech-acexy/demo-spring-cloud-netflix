package cn.acexy.tech.springcloud.netflix.ribbon.client.controller;

import cn.acexy.tech.springcloud.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/
@RestController
@RequestMapping(value = "user")
public class RibbonUserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "get-user")
    User getUser() {
        return restTemplate.getForObject("http://eureka-service/user/get", User.class);
    }

    @GetMapping(value = "get-users")
    List<User> getUsers() {
        return restTemplate.getForObject("http://eureka-service/user/get-more", List.class);
    }
}
