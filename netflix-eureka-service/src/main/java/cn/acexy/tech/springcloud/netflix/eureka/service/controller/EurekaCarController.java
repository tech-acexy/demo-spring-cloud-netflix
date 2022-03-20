package cn.acexy.tech.springcloud.netflix.eureka.service.controller;

import cn.acexy.tech.springcloud.common.bean.Car;
import cn.acexy.tech.springcloud.common.bean.User;
import cn.acexy.tech.springcloud.utils.SpringBeanContext;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间 : 2022/3/20 <br />
 *
 * @author : acexy@acexy.cn
 **/

@RestController
@RequestMapping(value = "car")
public class EurekaCarController {

    @GetMapping(value = "get")
    Car get() {
        return new Car(new User(SpringBeanContext.getBean(EurekaInstanceConfigBean.class).getInstanceId()));
    }

}
