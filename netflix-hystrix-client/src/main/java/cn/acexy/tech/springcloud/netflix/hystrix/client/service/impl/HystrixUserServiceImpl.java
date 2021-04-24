package cn.acexy.tech.springcloud.netflix.hystrix.client.service.impl;

import cn.acexy.tech.springcloud.netflix.hystrix.client.service.HystrixUserService;
import cn.acexy.tech.springcloud.common.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixUserServiceImpl implements HystrixUserService {

    final static Logger LOGGER = LoggerFactory.getLogger(HystrixUserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserFailed")
    public User getUser() {
        return restTemplate.getForObject("http://eureka-service/eureka/get-user", User.class);
    }

    private User getUserFailed() {
        LOGGER.error("       somethings wrong use fallback");
        User user = new User();
        user.setName("UNKNOWN");
        user.setAge((short) -1);
        return user;
    }
}
