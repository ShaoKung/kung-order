package com.kung.service.impl;

import com.kung.OrderQueryService;
import com.kung.atom.OrderLog;
import com.kung.mapper.OrderLogMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {
    @Autowired
    private OrderLogMapper orderLogMapper ;

    @Override
    public List<OrderLog> queryOrderList(Map<String, Object> param) {
        return orderLogMapper.selectByMap(param);
    }
}
