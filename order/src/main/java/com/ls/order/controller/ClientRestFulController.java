package com.ls.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: order->ClientController
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 17:42
 **/
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
