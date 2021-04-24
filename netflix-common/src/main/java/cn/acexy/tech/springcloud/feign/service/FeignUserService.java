package cn.acexy.tech.springcloud.feign.service;

import cn.acexy.tech.springcloud.common.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "user")
public interface FeignUserService {

    @GetMapping("get-user")
    User getUser();

    @GetMapping("get-user-by-name")
    User getUserByName(@RequestParam(name = "name") String name);
}
