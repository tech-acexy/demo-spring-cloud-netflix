package cn.acexy.tech.springcloud.netfilx.feign.advanced.client.service;

import cn.acexy.tech.springcloud.common.bean.User;
import cn.acexy.tech.springcloud.feign.service.FeignUserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创建时间 : 2021/4/19 <br />
 *
 * @author : acexy@acexy.cn
 **/
@FeignClient("feign-service/user")
public interface AdvancedUserService extends FeignUserService {

}