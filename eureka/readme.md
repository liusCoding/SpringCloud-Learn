# Eureka Server 

1.引入eureka-server的依赖
2.启动类加上@EnableEurekaServer注解，表示该注册为Eureka注册中心
3.将自己注册到注册中心
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
      
 不注册到注册中心
 register-with-eureka: false
 
4.修改应用的名称
      spring:
        application:
          name: eureka
      
      

      