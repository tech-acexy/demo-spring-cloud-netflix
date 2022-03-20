package cn.acexy.tech.springcloud.netflix.ribbon.client.controller;

import cn.acexy.tech.springcloud.common.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 创建时间 : 2022/3/20 <br />
 *
 * @author : acexy@acexy.cn
 **/

@RestController
@RequestMapping(value = "car")
public class RibbonCarController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("get")
    Car get() {
        return restTemplate.getForObject("http://feign-service/car/get", Car.class);
    }
}
