package com.kung.service;

import com.kung.EchoService;
import com.kung.OrderSubmitService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderReceiveController {

    @Reference
    OrderSubmitService orderSubmitService ;

    @GetMapping(value ="/api/orderCommon")
    @ResponseBody
    public String order(String json){
        return orderSubmitService.orderCommon(json);
    }
}
