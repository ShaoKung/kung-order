package com.kung.service;

//import com.kung.OrderDeleteService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kung.OrderQueryService;
import com.kung.OrderReceiveService;
//import com.kung.OrderUpdateService;
//import com.kung.atom.Order;
import com.kung.RestRespGeneral;
import com.kung.atom.OrderLog;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.LoggerFactory;
@RestController
public class OrderReceiveController {
    public static final Logger log = LoggerFactory.getLogger(OrderReceiveController.class);

    @Reference
    OrderReceiveService orderReceiveService ;

    @Reference
    OrderQueryService orderQueryService ;

    @RequestMapping(value ="/common/receive")
    @ResponseBody
    public String receive(@RequestBody String json){
        log.info("com.kung.service.OrderReceiveController.receive request :"+json);
        JSONObject jsonObject = JSON.parseObject(json);
        String authKey=jsonObject.getString("authKey");
        if(StringUtils.isEmpty(authKey)||!"9901".equals(authKey)){
            return  RestRespGeneral.failRespWithMsg("未授权访问,请联系管理员获取权限");
        }
        String result = orderReceiveService.orderReceive(jsonObject.getJSONObject("order").toJSONString());
        log.info("com.kung.service.OrderReceiveController.receive response :"+result);
        return result;
    }

    @RequestMapping(value ="/common/query")
    @ResponseBody
    public String queryOrderLog(@RequestBody String json){
        log.info("com.kung.service.OrderReceiveController.queryOrderLog request :"+json);
        JSONObject jsonObject = JSON.parseObject(json);
        String authKey=jsonObject.getString("authKey");
        // 鉴权
        if(StringUtils.isEmpty(authKey)||!"9901".equals(authKey)){
            return  RestRespGeneral.failRespWithMsg("未授权访问,请联系管理员获取权限");
        }
        List<OrderLog> orderLogList = orderQueryService.queryOrderList(jsonObject.getJSONObject("order"));
        JSONArray result =  (JSONArray) JSONObject.toJSON(orderLogList);
        String resp = RestRespGeneral.successResp(result.toJSONString()) ;
        log.info("com.kung.service.OrderReceiveController.queryOrderLog request :"+resp);
        return resp;
    }
}
