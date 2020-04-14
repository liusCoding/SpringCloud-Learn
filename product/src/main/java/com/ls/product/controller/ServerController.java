package com.ls.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: product->ServerController
 * @description:
 * @author: liushuai
 * @create: 2020-04-03 17:40
 **/
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is product ` msg  22";
    }
}
