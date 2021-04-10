package cn.acexy.tech.springcloud.netflix.ribbon.balanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/
@RestController
@RequestMapping(value = "ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "call-eureka-service")
    String callEurekaService() {
        return restTemplate.getForEntity("http://eureka-service/eureka/get-service", String.class).getBody();
    }
}
