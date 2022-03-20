package cn.acexy.tech.springcloud.netflix.eureka.service.controller;

import cn.acexy.tech.springcloud.common.bean.User;
import cn.acexy.tech.springcloud.utils.SpringBeanContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/

@RestController
@RequestMapping(value = "user")
public class EurekaUserController {

    final static Logger LOGGER = LoggerFactory.getLogger(EurekaUserController.class);
    Random random = new Random();

    @GetMapping(value = "get")
    User get() throws InterruptedException {
        int sleepMillis = random.nextInt(7000);
        LOGGER.info("will sleep ms {} to finish this request", sleepMillis);
        Thread.sleep(sleepMillis);
        return new User("来自eureka-service instance: " + SpringBeanContext.getBean(EurekaInstanceConfigBean.class).getInstanceId());
    }

    @GetMapping(value = "get-more")
    List<User> getMore() {
        String instanceId = SpringBeanContext.getBean(EurekaInstanceConfigBean.class).getInstanceId();
        return Arrays.asList(new User(instanceId), new User(instanceId));
    }

    @GetMapping(value = "get-by-name")
    User getByName(@RequestParam(name = "name") String name) {
        return new User(name);
    }
}
