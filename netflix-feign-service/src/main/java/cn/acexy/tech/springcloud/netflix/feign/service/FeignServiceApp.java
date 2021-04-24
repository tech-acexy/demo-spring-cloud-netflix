package cn.acexy.tech.springcloud.netflix.feign.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(FeignServiceApp.class);
    }
}
