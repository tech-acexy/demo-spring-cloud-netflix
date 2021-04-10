package cn.acexy.tech.springcloud.netflix.hystrix.client.service.impl;

import cn.acexy.tech.springcloud.netflix.hystrix.client.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixServiceImpl implements HystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callEurekaClientFallback")
    public String callEurekaClient() {
        return restTemplate.getForEntity("http://eureka-service/eureka/get-service", String.class).getBody();
    }

    private String callEurekaClientFallback() {
        return "callEurekaClientFallback";
    }
}
