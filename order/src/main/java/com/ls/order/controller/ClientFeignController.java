package com.ls.order.controller;

import com.ls.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: order->ClientFeignController
 * @description:
 * @author: liushuai
 * @create: 2020-04-11 17:46
 **/

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
