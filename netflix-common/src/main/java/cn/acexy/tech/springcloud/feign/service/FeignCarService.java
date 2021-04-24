package cn.acexy.tech.springcloud.feign.service;

import cn.acexy.tech.springcloud.common.bean.Car;
import cn.acexy.tech.springcloud.common.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "car")
public interface FeignCarService {

    @GetMapping(value = "get-car")
    Car getCar();

    @GetMapping(value = "get-car-by-owner")
    Car getCarByOwner(User owner);
}
