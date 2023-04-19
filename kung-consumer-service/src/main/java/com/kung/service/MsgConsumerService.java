package com.kung.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kung.atom.Order;
import com.kung.atom.OrderPay;
import com.kung.atom.OrderPost;
import com.kung.mapper.OrderMapper;
import com.kung.mapper.OrderPayMapper;
import com.kung.mapper.OrderPostMapper;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
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

    @Autowired
    private OrderPayMapper orderPayMapper ;

    @Autowired
    private OrderPostMapper orderPostMapper ;

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
        order.setProvinceCode(orderJson.getString("provinceCode"));
        order.setExtOrderId(orderJson.getString("extOrderId"));
        orderMapper.insert(order);
        JSONArray payInfo = orderJson.getJSONArray("payInfo");
        if(!CollectionUtils.isEmpty(payInfo)){
            for (int i=0;i<payInfo.size();i++) {
                JSONObject pay =  (JSONObject) payInfo.get(i);
                OrderPay orderPay = new OrderPay();
                orderPay.setOrderId(orderJson.getString("orderId"));
                orderPay.setPayAccount(pay.getString("payAccount"));
                orderPay.setPayId(pay.getString("payId"));
                orderPay.setPayTime(new Date());
                orderPay.setPayMoney(pay.getDouble("payMoney"));
                orderPayMapper.insert(orderPay);
            }
        }

        JSONArray postInfo = orderJson.getJSONArray("postInfo");
        if(!CollectionUtils.isEmpty(postInfo)){
            for (int i=0;i<postInfo.size();i++) {
              JSONObject post =  (JSONObject) postInfo.get(i);
                OrderPost orderPost = new OrderPost();
                orderPost.setPostId(post.getString("postId"));
                orderPost.setOrderId(orderJson.getString("orderId"));
                // 已经验视
                orderPost.setChecked(post.getString("checked"));
                orderPost.setCheckStaff(post.getString("checkStaff"));
                orderPost.setCollectStaff(post.getString("collectStaff"));
                orderPost.setCollectTime(new Date());
                orderPost.setDestAddr(post.getString("destAddr"));
                orderPost.setDestCity(post.getString("destCity"));
                orderPost.setDestDist(post.getString("destDist"));
                orderPost.setDestProv(post.getString("destProv"));
                orderPost.setFromAddr(post.getString("fromAddr"));
                orderPost.setFromDist(post.getString("fromDist"));
                orderPost.setFromCity(post.getString("fromCity"));
                orderPost.setFromProv(post.getString("fromProv"));
                orderPost.setReceName(post.getString("receName"));
                orderPost.setRecePhon(post.getString("recePhon"));
                orderPost.setWeight(post.getDouble("weight"));
                orderPostMapper.insert(orderPost);
            }
        }
    }
}
