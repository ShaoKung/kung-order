package com.kung.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kung.OrderSubmitService;
import com.kung.RestRespGeneral;
import com.kung.UniqIDGeneral;
import org.apache.dubbo.config.annotation.Service;

@Service
public class OrderSubmitServiceImpl implements OrderSubmitService {
    @Override
    public String orderCommon(String json) {
        String orderId=RestRespGeneral.successResp(UniqIDGeneral.generalUUID());
        JSONObject orderJson = JSON.parseObject(json);

        return RestRespGeneral.successResp(UniqIDGeneral.generalUUID());
    }
}
