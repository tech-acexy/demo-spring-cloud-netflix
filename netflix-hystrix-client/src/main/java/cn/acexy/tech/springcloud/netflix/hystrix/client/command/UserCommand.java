package cn.acexy.tech.springcloud.netflix.hystrix.client.command;

import cn.acexy.tech.springcloud.netflix.hystrix.client.bean.Template;
import cn.acexy.tech.springcoud.common.bean.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 创建时间 : 2021/4/10 <br />
 *
 * @author : acexy@acexy.cn
 **/
@Component
public class UserCommand extends HystrixCommand<User> {

    @Autowired
    private RestTemplate restTemplate;

    private static final Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("user"))
            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                    .withExecutionTimeoutEnabled(true)
                    .withExecutionTimeoutInMilliseconds(2000)
                    .withFallbackEnabled(true)
            );

    public UserCommand() {
        super(setter);
    }

    protected User run() {
        return restTemplate.getForObject("http://eureka-service/eureka/get-user", User.class);
    }
}
