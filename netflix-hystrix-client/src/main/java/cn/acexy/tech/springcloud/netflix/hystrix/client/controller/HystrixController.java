package cn.acexy.tech.springcloud.netflix.hystrix.client.controller;

import cn.acexy.tech.springcloud.netflix.hystrix.client.command.UserCommand;
import cn.acexy.tech.springcloud.netflix.hystrix.client.command.UserAnnotationCommand;
import cn.acexy.tech.springcloud.netflix.hystrix.client.command.UserObservableCommand;
import cn.acexy.tech.springcloud.netflix.hystrix.client.service.HystrixUserService;
import cn.acexy.tech.springcoud.common.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observer;
import rx.observables.BlockingObservable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "hystrix")
public class HystrixController {
    static final Logger LOGGER = LoggerFactory.getLogger(HystrixController.class);

    @Autowired
    private HystrixUserService hystrixUserService;

    @Autowired
    private UserAnnotationCommand userAnnotationCommand;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "get-user")
    User getUser() throws ExecutionException, InterruptedException {
        int randomValue = (int) (Math.random() * 4) + 1;
        switch (randomValue) {
            case 1:
                LOGGER.info("HystrixUserService");
                LOGGER.info("   getUser");
                return hystrixUserService.getUser();
            case 2:
                UserCommand userCommand = new UserCommand(restTemplate);
                LOGGER.info("UserCommand");
                randomValue = (int) (Math.random() * 4) + 1;
                switch (randomValue) {
                    case 1:
                        LOGGER.info("   execute");
                        return userCommand.execute();
                    case 2:
                        LOGGER.info("   execute async");
                        Future<User> userFuture = userCommand.queue();
                        return userFuture.get();
                    case 3:
                        LOGGER.info("   observe");
                        return getUserFromObservable(userCommand.observe(), true);
                    default:
                        LOGGER.info("   toObservable");
                        return getUserFromObservable(userCommand.toObservable(), false);
                }
            case 3:
                LOGGER.info("UserCommandAnnotation");
                randomValue = (int) (Math.random() * 10) + 1;
                if (randomValue % 2 == 0) {
                    LOGGER.info("   getUser");
                    return userAnnotationCommand.getUser();
                } else {
                    LOGGER.info("   getUserAsync");
                    Future<User> userFuture = userAnnotationCommand.getUserAsync();
                    return userFuture.get();
                }
            case 4:
                LOGGER.info("UserObservableCommand");
                UserObservableCommand userObservableCommand = new UserObservableCommand(restTemplate);
                randomValue = (int) (Math.random() * 10) + 1;
                if (randomValue % 2 == 0) {
                    LOGGER.info("   observe");
                    return getUserFromObservable(userObservableCommand.observe(), true);
                } else {
                    LOGGER.info("   toObservable");
                    return getUserFromObservable(userObservableCommand.toObservable(), false);
                }
        }
        LOGGER.error("bad random value {}", randomValue);
        return null;
    }


    private User getUserFromObservable(Observable<User> observable, boolean isHot) throws InterruptedException {
        if (isHot) {
            final User[] users = new User[1];

            observable.subscribe(new Observer<User>() {
                public void onCompleted() {
                    LOGGER.info("       request complated");
                }

                public void onError(Throwable throwable) {
                    LOGGER.info("       request onError");
                    LOGGER.info("       auto set fallback result");
                    User user = new User();
                    user.setName("UNKNOWN");
                    users[0] = user;
                }

                public void onNext(User user) {
                    LOGGER.info("       request onNext");
                    users[0] = user;
                }
            });
            LOGGER.info("       sleep 3s to wait request finish and get user");
            Thread.sleep(3000);
            return users[0];
        } else {
            BlockingObservable<User> blockingObservable = observable.toBlocking();
            LOGGER.info("       observable.toBlocking");
            return blockingObservable.first();
        }
    }
}
