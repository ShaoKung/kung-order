package com.kung.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kung.OrderSubmitService;
import com.kung.RestRespGeneral;
import com.kung.UniqIDGeneral;
import com.kung.atom.OrderLog;
import com.kung.mapper.OrderLogMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;


@Service
public class OrderSubmitServiceImpl implements OrderSubmitService {

    @Autowired
    private OrderLogMapper orderLogMapper ;

    @Override
    public String orderCommon(String json) {
        String orderId=UniqIDGeneral.generalUUID();
        JSONObject orderJson = JSON.parseObject(json);
        //补齐报文中内部订单ID
        orderJson.put("orderId",orderId);
        OrderLog orderLog=new OrderLog();
        orderLog.setOrderId(orderId);
        orderLog.setProvinceCode(orderJson.getString("provinceCode"));
        orderLog.setAcceptDate(new Date());
        orderLog.setOrderMsg(orderJson.toJSONString());
        orderLogMapper.insert(orderLog);
        return RestRespGeneral.successResp(orderId);
    }
}
