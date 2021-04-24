package cn.acexy.tech.springcloud.netfilx.feign.advanced.client.controller;

import cn.acexy.tech.springcloud.common.bean.Car;
import cn.acexy.tech.springcloud.common.bean.User;
import cn.acexy.tech.springcloud.netfilx.feign.advanced.client.service.AdvancedCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "advanced-feign/car")
public class AdvancedFeignCarController {

    @Autowired
    private AdvancedCarService advancedCarService;

    @GetMapping(value = "get-car")
    Car getCar(){
        return advancedCarService.getCar();
    }

    @GetMapping(value = "get-car-by-owner")
    Car getCarByOwner(User owner){
        return advancedCarService.getCarByOwner(owner);
    }
}
