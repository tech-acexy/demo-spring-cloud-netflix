package cn.acexy.tech.springcloud.netflix.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServiceApp {

    public static void main(String[] args) {
        new SpringApplication(EurekaServiceApp.class).run(args);
    }
}
