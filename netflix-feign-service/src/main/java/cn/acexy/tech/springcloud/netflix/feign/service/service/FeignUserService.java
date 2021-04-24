package cn.acexy.tech.springcloud.netflix.feign.service.service;

import cn.acexy.tech.springcoud.common.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("feign")
public interface FeignUserService {

    @GetMapping("get-user")
    User getUser();

    @GetMapping("get-user-by-name")
    User getUserByName(@RequestParam(name = "name") String name);
}
