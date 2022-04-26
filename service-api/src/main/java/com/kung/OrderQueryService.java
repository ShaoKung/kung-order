package com.kung;

import com.kung.atom.Order;

import java.util.List;
import java.util.Map;

public interface OrderQueryService {
    public List<Order> queryOrderList(Map<String,Object> param);
}
