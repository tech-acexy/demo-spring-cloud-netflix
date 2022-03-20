package cn.acexy.tech.springcloud.netfilx.feign.advanced.client.controller;

import cn.acexy.tech.springcloud.common.bean.Car;
import cn.acexy.tech.springcloud.common.bean.User;
import cn.acexy.tech.springcloud.netfilx.feign.advanced.client.service.AdvancedCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "advanced-feign-car")
public class AdvancedFeignCarController {

    static final Logger LOGGER = LoggerFactory.getLogger(AdvancedFeignCarController.class);

    @Autowired
    private AdvancedCarService advancedCarService;

    @GetMapping(value = "get-car")
    Car getCar() {
        return advancedCarService.get();
    }

    @GetMapping(value = "get-car-by-owner")
    Car getCarByOwner(User owner) {
        Car car = advancedCarService.getByOwner(owner);
        LOGGER.info("response car owner name {}", car.getOwner().getName());
        return car;
    }
}
