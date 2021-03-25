package cn.acexy.tech.springcloud.netflix.ribbon.balanced;

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
public class RibbonBalancedApp {

    public static void main(String[] args) {
        SpringApplication.run(RibbonBalancedApp.class, args);
    }
}
