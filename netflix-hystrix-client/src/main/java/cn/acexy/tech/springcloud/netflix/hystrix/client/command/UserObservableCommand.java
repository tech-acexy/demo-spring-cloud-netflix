package cn.acexy.tech.springcloud.netflix.hystrix.client.command;

import cn.acexy.tech.springcloud.common.bean.User;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observer;
import rx.observables.SyncOnSubscribe;

/**
 * 创建时间 : 2021/4/14 <br />
 *
 * @author : acexy@acexy.cn
 **/
public class UserObservableCommand extends HystrixObservableCommand<User> {

    static final Logger LOGGER = LoggerFactory.getLogger(UserObservableCommand.class);

    private static final HystrixObservableCommand.Setter setter = HystrixObservableCommand.Setter
            .withGroupKey(HystrixCommandGroupKey.Factory.asKey("user"))

            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                    .withExecutionTimeoutEnabled(true)
                    .withExecutionTimeoutInMilliseconds(1500)
                    .withFallbackEnabled(true)
            );

    private RestTemplate restTemplate;

    public UserObservableCommand(RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected Observable<User> construct() {

        return Observable.create(
                new SyncOnSubscribe<Object, User>() {

                    @Override
                    protected Object generateState() {
                        return null;
                    }

                    @Override
                    protected User next(Object state, Observer<? super User> observer) {
                        User user = restTemplate.getForObject("http://eureka-service/eureka/get-user", User.class);
                        observer.onNext(user);
                        observer.onCompleted();
                        return null;
                    }
                }
        );
    }

    @Override
    protected Observable<User> resumeWithFallback() {
        LOGGER.error("       somethings wrong use fallback");
        return Observable.create(
                new SyncOnSubscribe<Object, User>() {

                    @Override
                    protected Object generateState() {
                        return null;
                    }

                    @Override
                    protected User next(Object state, Observer<? super User> observer) {
                        User user = new User();
                        user.setName("UNKNOWN");
                        observer.onNext(user);
                        observer.onCompleted();
                        return null;
                    }
                }
        );
    }
}
