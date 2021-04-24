package cn.acexy.tech.springcloud.netfilx.feign.advanced.client.service;

import cn.acexy.tech.springcoud.common.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创建时间 : 2021/4/19 <br />
 *
 * @author : acexy@acexy.cn
 **/
@FeignClient("eureka-service/eureka")
public interface AdvancedUserService {

    @GetMapping("get-user")
    User getUser();

    @GetMapping("get-user-by-name")
    User getUserByName(@RequestParam(name = "name") String name);
}