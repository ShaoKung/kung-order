package com.kung.service;

//import com.kung.EchoService;
//import com.kung.OrderDeleteService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kung.OrderQueryService;
import com.kung.OrderSubmitService;
//import com.kung.OrderUpdateService;
//import com.kung.atom.Order;
import com.kung.RestRespGeneral;
import com.kung.atom.OrderLog;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.LoggerFactory;
@RestController
public class OrderReceiveController {
    public static final Logger log = LoggerFactory.getLogger(OrderReceiveController.class);

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
        log.info("com.kung.service.OrderReceiveController.save request :"+json);
        System.out.println(json);
        String result = orderSubmitService.orderCommon(json);
        log.info("com.kung.service.OrderReceiveController.save response :"+result);
        return result;
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
    public String queryOrderLog(@RequestBody String json){
        log.info("com.kung.service.OrderReceiveController.queryOrderLog request :"+json);
        JSONObject jsonObject = JSON.parseObject(json);
        String appkey=jsonObject.getString("APPKEY");
        jsonObject.remove("APPKEY");
        List<OrderLog> orderLogList = orderQueryService.queryOrderList(jsonObject);
        JSONArray result =  (JSONArray) JSONObject.toJSON(orderLogList);
        String resp = RestRespGeneral.successResp(result.toJSONString()) ;
        log.info("com.kung.service.OrderReceiveController.queryOrderLog request :"+resp);
        return resp;
    }
}
