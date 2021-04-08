package cn.acexy.tech.springcloud.netflix.eureka.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建时间 : 2021/3/25 <br />
 *
 * @author : acexy@acexy.cn
 **/

@RestController
@RequestMapping(value = "eureka")
public class EurekaController {

    final static Logger LOGGER = LoggerFactory.getLogger(EurekaController.class);

    @GetMapping(value = "get-client")
    String getClient() {
        return  System.getProperty("os.name") + " get your request";
    }
}
