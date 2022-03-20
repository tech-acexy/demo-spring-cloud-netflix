package cn.acexy.tech.springcloud.netflix.ribbon.client;

import cn.acexy.tech.springcloud.netflix.ribbon.rule.RibbonCarRule;
import cn.acexy.tech.springcloud.netflix.ribbon.rule.RibbonUserRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/

@SpringBootApplication
@EnableDiscoveryClient
// 配置默认Ribbon策略为RandomRule
@RibbonClients(defaultConfiguration = RandomRule.class)
public class RibbonClientApp {

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientApp.class, args);
    }

}
