package cn.acexy.tech.springcloud.feign.service;

import cn.acexy.tech.springcloud.common.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "user")
public interface FeignUserService {

    @GetMapping("get")
    User get();

    @GetMapping("get-by-name")
    User getByName(@RequestParam(name = "name") String name);
}
