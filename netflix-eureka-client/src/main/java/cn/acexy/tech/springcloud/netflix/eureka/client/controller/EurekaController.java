package cn.acexy.tech.springcloud.netflix.eureka.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/

@RestController
@RequestMapping(value = "eureka")
public class EurekaController {

    @GetMapping(value = "get-client")
    String getClient() {
        return "client";
    }
}
