package cn.acexy.tech.springcloud.netflix.feign.client.service;

import cn.acexy.tech.springcloud.common.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创建时间 : 2021/4/19 <br />
 *
 * @author : acexy@acexy.cn
 **/
@FeignClient("eureka-service/user")
public interface EurekaUserService {

    @GetMapping("get")
    User get();

    @GetMapping("get-by-name")
    User getByName(@RequestParam(name = "name") String name);
}