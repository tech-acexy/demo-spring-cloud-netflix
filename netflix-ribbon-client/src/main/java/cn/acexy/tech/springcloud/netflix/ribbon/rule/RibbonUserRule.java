package cn.acexy.tech.springcloud.netflix.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 创建时间 : 2022/3/20 <br />
 *
 * @author : acexy@acexy.cn
 **/
@Configuration
public class RibbonUserRule {

    // 这个策略需要配置在主程序包中，这样可以分享该策略给所有RibbonClient
    @Bean
    public IRule rule() {
        // 启用完全随机策略 默认为按照顺序轮询策略
        return new CustomRule();
    }

    /**
     * 自定义规则，只取第一个可用的服务端
     */
    public static class CustomRule extends AbstractLoadBalancerRule {

        @Override
        public void initWithNiwsConfig(IClientConfig iClientConfig) {

        }

        @Override
        public Server choose(Object o) {
            ILoadBalancer iLoadBalancer = getLoadBalancer();
            if (iLoadBalancer != null) {
                List<Server> reachableServers = iLoadBalancer.getReachableServers();
                return reachableServers.get(0);
            }
            return null;
        }
    }
}
