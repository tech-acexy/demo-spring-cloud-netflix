package cn.acexy.tech.springcloud.netflix.ribbon.client.configuration.rule;

import cn.acexy.tech.springcloud.netflix.ribbon.rule.RibbonUserRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 创建时间 : 2022/3/20 <br />
 *
 * @author : acexy@acexy.cn
 **/
// 配置请求eureka-service的serviceId使用RibbonUserClientRule负载策略
@RibbonClient(name = "eureka-service", configuration = RibbonUserRule.class)
public class EurekaService {
}
