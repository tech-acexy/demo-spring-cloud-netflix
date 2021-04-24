package cn.acexy.tech.springcloud.netflix.feign.service.controller;

import cn.acexy.tech.springcloud.common.bean.Car;
import cn.acexy.tech.springcloud.common.bean.User;
import cn.acexy.tech.springcloud.feign.service.FeignCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignCarController implements FeignCarService {

    final static Logger LOGGER = LoggerFactory.getLogger(FeignCarController.class);

    public Car getCar() {
        LOGGER.info("get request return car");
        return new Car();
    }

    public Car getCarByOwner(User owner) {
        LOGGER.info("get request return car with owner");
        return new Car(owner);
    }
}
