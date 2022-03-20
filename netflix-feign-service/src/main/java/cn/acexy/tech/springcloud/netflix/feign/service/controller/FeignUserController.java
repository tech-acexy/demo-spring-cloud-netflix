package cn.acexy.tech.springcloud.netflix.feign.service.controller;

import cn.acexy.tech.springcloud.feign.service.FeignUserService;
import cn.acexy.tech.springcloud.common.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignUserController implements FeignUserService {

    final static Logger LOGGER = LoggerFactory.getLogger(FeignUserController.class);

    public User get() {
        LOGGER.info("get request return user");
        return new User();
    }

    public User getByName(String name) {
        LOGGER.info("get request return user with name");
        return new User(name);
    }
}
