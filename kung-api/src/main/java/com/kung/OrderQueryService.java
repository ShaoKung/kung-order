package com.kung;

import com.kung.atom.OrderLog;

import java.util.List;
import java.util.Map;

public interface OrderQueryService {
    public List<OrderLog> queryOrderList(Map<String,Object> param);
}
