package cn.acexy.tech.springcloud.netflix.ribbon.balanced.bean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/
@Component
public class Template {

    @Bean
    @LoadBalanced
    RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
