package cn.acexy.tech.springcloud.netflix.hystrix.client.command;


import cn.acexy.tech.springcoud.common.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserCommandAnnotation {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand
    public User getUser() {
        return restTemplate.getForObject("http://eureka-service/eureka/get-user", User.class);
    }
}
