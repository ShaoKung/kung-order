package com.kung.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kung.atom.Order;
import com.kung.mapper.OrderMapper;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import java.util.Date;

@Service
@RocketMQMessageListener(
        topic = "TopicTest",
        consumerGroup = "test-group",
        selectorExpression = "*",
        consumeMode = ConsumeMode.CONCURRENTLY
)
public class MsgConsumerService implements RocketMQListener<String> {
    public static final Logger log = LoggerFactory.getLogger(MsgConsumerService.class);

    @Autowired
    private OrderMapper orderMapper ;
    @Override
    public void onMessage(String msg) {
        log.info("com.kung.service.MsgConsumerService.onMessage receive info :"+ msg);
        JSONObject json= JSON.parseObject(msg);
        JSONObject orderJson = json.getJSONObject("orderMsg");
        Order order=new Order();
        order.setOrderId(orderJson.getString("orderId"));
        order.setAddress(orderJson.getString("address"));
        order.setCity(orderJson.getString("city"));
        order.setCommCount(orderJson.getIntValue("commCount"));
        order.setCommId(orderJson.getString("commId"));
        order.setCommPrice(orderJson.getDouble("commPrice"));
        order.setDistrict(orderJson.getString("district"));
        order.setOrderTime(new Date());
        order.setPhone(orderJson.getString("phone"));
        order.setPostId(orderJson.getString("postId"));
        order.setProvinceCode(orderJson.getString("provinceCode"));
        orderMapper.insert(order);
    }
}
