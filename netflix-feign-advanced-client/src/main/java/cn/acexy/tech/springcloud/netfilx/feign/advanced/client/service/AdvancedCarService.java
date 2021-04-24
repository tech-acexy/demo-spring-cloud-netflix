package cn.acexy.tech.springcloud.netfilx.feign.advanced.client.service;

import cn.acexy.tech.springcloud.feign.service.FeignCarService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("feign-service")
public interface AdvancedCarService extends FeignCarService {
}
