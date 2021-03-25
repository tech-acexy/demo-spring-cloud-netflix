package cn.acexy.tech.springcloud.netflix.ribbon.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApp.class, args);
    }
}
