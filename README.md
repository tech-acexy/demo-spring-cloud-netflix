# demo-spring-cloud-netflix

spring-cloud 基于Netflix相关模块

- eureka-center 

  ```
  eureka注册中心服务
  ```
  
- eureka-service

  ```
  注册至eureka上作为服务提供方
  ```

- feign-service

  ```
  基于feign框架注册至eureka上作为服务提供方
  ```

- ribbon-client

  ```
  基于ribbon负载均衡策略，提供负责均衡的服务来请求eurka-service
  ```

- feign-client

  ```
  基于feign框架，分别请求注册中心上eureka-service&feign-service服务
  ```
  
- feign-advanced-client
  
  ```
  基于feign框架，更加简洁的请求注册中心上feign-service服务
  ```
  
- hystrix-client

  ```
  基于hystrix熔断器策略，请求注册中心eureka服务
  ```

- zuul-gateway

  ```
  zuul网关
  ```