package cn.acexy.tech.springcloud.netflix.eureka.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/

@SpringBootApplication
@EnableEurekaServer
public class EurekaCenterApp {

    public static void main(String[] args) {
        new SpringApplication(EurekaCenterApp.class).run(args);
    }
}
