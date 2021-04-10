package cn.acexy.tech.springcloud.netflix.eureka.service.controller;

import cn.acexy.tech.springcoud.common.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/

@RestController
@RequestMapping(value = "eureka")
public class EurekaController {

    final static Logger LOGGER = LoggerFactory.getLogger(EurekaController.class);
    Random random = new Random();

    @GetMapping(value = "get-user")
    User getService() throws InterruptedException {
        int sleepMillis = random.nextInt(3000);
        LOGGER.info("will sleep ms {} to finish this request", sleepMillis);
        Thread.sleep(sleepMillis);
        return new User();
    }
}
