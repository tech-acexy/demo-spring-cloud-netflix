package cn.acexy.tech.springcloud.netflix.hystrix.client.controller;

import cn.acexy.tech.springcloud.netflix.hystrix.client.command.UserCommand;
import cn.acexy.tech.springcloud.netflix.hystrix.client.service.HystrixUserService;
import cn.acexy.tech.springcoud.common.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "hystrix")
public class HystrixController {
    static final Logger LOGGER = LoggerFactory.getLogger(HystrixController.class);

    @Autowired
    private HystrixUserService hystrixUserService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "get-user")
    User getUser() throws ExecutionException, InterruptedException {
        UserCommand userCommand = new UserCommand(restTemplate);
        int randomValue = (int) (Math.random() * 3) + 1;
        switch (randomValue) {
            case 1:
                LOGGER.info("HystrixUserService.getUser");
                return hystrixUserService.getUser();
            case 2:
                LOGGER.info("UserCommand sync execute");
                return userCommand.execute();
            case 3:
                LOGGER.info("UserCommand async queue");
                Future<User> userFuture = userCommand.queue();
                new Thread(new Runnable() {
                    public void run() {
                        LOGGER.info("UserCommand do something else");
                    }
                }).start();
                return userFuture.get();
        }
        LOGGER.error("bad random value {}", randomValue);
        return null;
    }

}
