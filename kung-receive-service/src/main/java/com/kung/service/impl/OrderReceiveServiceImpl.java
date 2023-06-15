package com.kung.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kung.OrderReceiveService;
import com.kung.RestRespGeneral;
import com.kung.UniqIDGeneral;
import com.kung.atom.OrderLog;
import com.kung.constant.CommonEnum;
import com.kung.mapper.OrderLogMapper;
import org.apache.dubbo.config.annotation.Service;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import org.slf4j.LoggerFactory;


@Service
public class OrderReceiveServiceImpl implements OrderReceiveService {

    @Autowired
    private OrderLogMapper orderLogMapper ;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    private static final Logger log = LoggerFactory.getLogger(OrderReceiveServiceImpl.class);

    public static final String COMMON_MSG="1";

    @Override
    public String orderReceive(String json) {
        log.info("com.kung.service.impl.OrderSubmitServiceImpl.orderReceive request :"+json);
        String orderId=UniqIDGeneral.generalUUID();
        JSONObject orderJson = JSON.parseObject(json);
        //补齐报文中内部订单ID
        orderJson.put("orderId",orderId);
        OrderLog orderLog=new OrderLog();
        orderLog.setOrderId(orderId);
        orderLog.setProvinceCode(orderJson.getString("provinceCode"));
        orderLog.setAcceptDate(new Date());
        orderLog.setOrderMsg(orderJson.toJSONString());
        // 下单消息
        orderLog.setType(COMMON_MSG);
        orderLogMapper.insert(orderLog);
        //发送消息用以消费者落表
        rocketMQTemplate.convertAndSend("TopicTest",orderLog);
        String result = RestRespGeneral.successResp(orderId);
        log.info("com.kung.service.impl.OrderSubmitServiceImpl.orderReceive response :"+result);
        return result ;
    }
}
