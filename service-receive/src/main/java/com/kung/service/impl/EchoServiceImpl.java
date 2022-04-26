package com.kung.service.impl;

import com.kung.EchoService;
import org.apache.dubbo.config.annotation.Service;


@Service
public class EchoServiceImpl implements EchoService {

    @Override
    public String echoParam(String param) {
        return param;
    }
}
