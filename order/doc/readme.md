# 应用通信

+ RestTemplate
+ 订单服务->商品服务


1.RestTemplate使用

配置restTemplate
```java

@Component
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
```

注入使用
```java

@RestController
public class ClientRestFulController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;



    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/getProductMsg")
    public String getProductMsgForRest(){
        //1.第一种方式(直接使用restTemplate,url写死)
//        RestTemplate restTemplate = new RestTemplate();
//        String msg = restTemplate.getForObject("http://localhost:8070/msg", String.class);


        //2.第二种方式（利用LoadBanlancer通过应用名获取url，然后使用RestTemplate）
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()+"/msg");
//
//        String msg = restTemplate.getForObject(url, String.class);

        //3.第三种方式(利用@LoadBalanced，可在restTemplate里使用应用名字)
        String msg = restTemplate.getForObject("http://PRODUCT/msg",String.class);

        return msg;
    }



}
```

2.Feign

导入依赖
```java


        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-feign</artifactId>
            <version>2.0.0.M1</version>
        </dependency>
```

启动类加注解
> @EnableFeignClients

定义客户端接口
使用@FeignClient(name = "product")注解  name用提供服务的名字
```java

@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();
}

```

注入使用
```java

@RestController
@Slf4j
public class ClientFeignController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsgForFeign")
    public String getProductMsgForFeign(){
        String msg = productClient.productMsg();
        log.info("【msg】:{}",msg);
        return msg;
    }
}

```