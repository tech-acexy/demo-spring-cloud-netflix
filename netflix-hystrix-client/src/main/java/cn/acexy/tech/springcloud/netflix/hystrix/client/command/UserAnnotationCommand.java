package cn.acexy.tech.springcloud.netflix.hystrix.client.command;


import cn.acexy.tech.springcoud.common.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class UserAnnotationCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAnnotationCommand.class);
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "true")
    }, fallbackMethod = "getFallback")
    public User getUser() {
        return restTemplate.getForObject("http://eureka-service/eureka/get-user", User.class);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "true")
    }, fallbackMethod = "getFallback")
    public Future<User> getUserAsync() {
        return new AsyncResult<User>() {
            public User invoke() {
                return restTemplate.getForObject("http://eureka-service/eureka/get-user", User.class);
            }
        };
    }

    protected User getFallback() {
        LOGGER.error("       somethings wrong use fallback");
        User user = new User();
        user.setName("UNKNOWN");
        return user;
    }
}
