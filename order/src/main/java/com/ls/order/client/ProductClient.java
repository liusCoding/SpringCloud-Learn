package com.ls.order.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: order->ProductClient
 * @description:
 * @author: liushuai
 * @create: 2020-04-11 17:41
 **/

@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();
}
