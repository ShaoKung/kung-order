package com.kung.service;

//import com.kung.EchoService;
//import com.kung.OrderDeleteService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kung.OrderQueryService;
import com.kung.OrderSubmitService;
//import com.kung.OrderUpdateService;
//import com.kung.atom.Order;
import com.kung.atom.OrderLog;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderReceiveController {

    @Reference
    OrderSubmitService orderSubmitService ;

    @Reference
    OrderQueryService orderQueryService ;

//    @Reference
//    OrderUpdateService orderUpdateService;
//
//    @Reference
//    OrderDeleteService orderDeleteService;

    @RequestMapping(value ="/api/save")
    @ResponseBody
    public String save(@RequestBody String json){
        System.out.println(json);
        return orderSubmitService.orderCommon(json);
    }

//    @GetMapping(value ="/api/update")
//    @ResponseBody
//    public String update(String json){
//        return orderUpdateService.updateOrderById(new Order());
//    }
//
//    @GetMapping(value ="/api/delete")
//    @ResponseBody
//    public String delete(String json){
//        return orderDeleteService.deleteOrder(new Order());
//    }

    @RequestMapping(value ="/api/query")
    @ResponseBody
    public List<OrderLog> queryOrderLog(@RequestBody String json){
        System.out.println(json);
        JSONObject jsonObject = JSON.parseObject(json);
        return orderQueryService.queryOrderList(jsonObject);
    }
}
