package cn.acexy.tech.springcloud.netflix.ribbon.client.configuration.rule;

import cn.acexy.tech.springcloud.netflix.ribbon.rule.RibbonCarRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 创建时间 : 2022/3/20 <br />
 *
 * @author : acexy@acexy.cn
 **/
@RibbonClient(name = "feign-service", configuration = RibbonCarRule.class)
public class FeignService {
}
