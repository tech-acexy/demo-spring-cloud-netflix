package cn.acexy.tech.springcloud.netflix.feign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 创建时间 : 2021/4/19 <br />
 *
 * @author : acexy@acexy.cn
 **/

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FeignClientApp {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApp.class);
    }
}
