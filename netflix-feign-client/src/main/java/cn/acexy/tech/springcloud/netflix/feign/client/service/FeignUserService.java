package cn.acexy.tech.springcloud.netflix.feign.client.service;

import cn.acexy.tech.springcloud.common.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("feign-service/user")
public interface FeignUserService {

    @GetMapping("get")
    User get();

    @GetMapping("get-by-name")
    User getByName(@RequestParam(name = "name") String name);
}
