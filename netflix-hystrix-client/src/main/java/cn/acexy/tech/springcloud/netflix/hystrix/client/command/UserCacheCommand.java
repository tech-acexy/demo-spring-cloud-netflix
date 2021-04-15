package cn.acexy.tech.springcloud.netflix.hystrix.client.command;

import cn.acexy.tech.springcoud.common.bean.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class UserCacheCommand extends HystrixCommand<User> {

    final static Logger LOGGER = LoggerFactory.getLogger(UserCacheCommand.class);

    private final RestTemplate restTemplate;

    private final String name;

    private static final Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("user-cache"))
            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                    .withExecutionTimeoutEnabled(true)
                    .withExecutionTimeoutInMilliseconds(3000)
            );

    public UserCacheCommand(RestTemplate restTemplate, String name) {
        super(setter);
        this.restTemplate = restTemplate;
        this.name = name;
    }

    @Override
    protected User run() {
        User user = restTemplate.getForObject("http://eureka-service/eureka/get-user", User.class);
        LOGGER.info("service response user name is > {} query user name is > {}", user.getName(), name);
        return user;
    }

    @Override
    protected String getCacheKey() {
        return name;
    }
}
