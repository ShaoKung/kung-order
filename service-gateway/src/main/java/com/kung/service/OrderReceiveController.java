package com.kung.service;

//import com.kung.EchoService;
//import com.kung.OrderDeleteService;
import com.kung.OrderSubmitService;
//import com.kung.OrderUpdateService;
//import com.kung.atom.Order;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderReceiveController {

    @Reference
    OrderSubmitService orderSubmitService ;

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
}
