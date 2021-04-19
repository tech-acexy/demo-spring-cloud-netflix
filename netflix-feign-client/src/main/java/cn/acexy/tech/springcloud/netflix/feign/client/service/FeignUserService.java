package cn.acexy.tech.springcloud.netflix.feign.client.service;

import cn.acexy.tech.springcoud.common.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建时间 : 2021/4/19 <br />
 *
 * @author : acexy@acexy.cn
 **/
@FeignClient("eureka-service")
public interface FeignUserService {

    @RequestMapping("get-user")
    User getUser();

}