package cn.acexy.tech.springcloud.netflix.ribbon.rule;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建时间 : 2022/3/20 <br />
 * 配置Ribbon全局负责均衡策略
 *
 * @author : acexy@acexy.cn
 **/
@Configuration
public class RibbonCarRule {

    @Bean
    public IRule rule() {
        // 当前设置默认为完全随机策略 调整为按照顺序轮询策略
        return new RoundRobinRule();
    }

}
