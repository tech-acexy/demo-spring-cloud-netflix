package cn.acexy.tech.springcloud.netflix.zuul.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class FeignClientFilter extends ZuulFilter {

    static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFilter.class);

    public String filterType() {
        // per : 请求被路由之前被执行
        return "pre";
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        LOGGER.info("requestPath {}", request.getRequestURI());
        return null;
    }
}
