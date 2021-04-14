package cn.acexy.tech.springcloud.netflix.hystrix.client.command;

import cn.acexy.tech.springcoud.common.bean.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 创建时间 : 2021/4/10 <br />
 *
 * @author : acexy@acexy.cn
 **/
public class UserCommand extends HystrixCommand<User> {

    static final Logger LOGGER = LoggerFactory.getLogger(UserCommand.class);

    private RestTemplate restTemplate;

    private static final Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("user"))
            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                    .withExecutionTimeoutEnabled(true)
                    .withExecutionTimeoutInMilliseconds(2000)
                    .withFallbackEnabled(true)
            );

    public UserCommand(RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    protected User run() {
        return restTemplate.getForObject("http://eureka-service/eureka/get-user", User.class);
    }

    @Override
    protected User getFallback() {
        LOGGER.error("       somethings wrong use fallback");
        User user = new User();
        user.setName("UNKNOWN");
        return user;
    }
}
