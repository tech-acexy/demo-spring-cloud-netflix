package cn.acexy.tech.springcloud.netflix.hystrix.client;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class HystrixClientApp {

    public static void main(String[] args) {
        SpringApplication.run(HystrixClientApp.class, args);
    }
}
