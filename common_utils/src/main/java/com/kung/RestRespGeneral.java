package com.kung;

import com.alibaba.fastjson.JSONObject;
public class RestRespGeneral {
    public static String successResp(String data){
        JSONObject rsp = new JSONObject();
        rsp.put("respCode","0000");
        rsp.put("respDesc","执行成功");
        rsp.put("data",data);
        return rsp.toString();
    }

    public static String failResp(){
        JSONObject rsp = new JSONObject();
        rsp.put("respCode","9999");
        rsp.put("respDesc","执行失败");
        return rsp.toString();
    }

    public static String failRespWithCode(String code){
        JSONObject rsp = new JSONObject();
        rsp.put("respCode",code);
        rsp.put("respDesc","执行失败");
        return rsp.toString();
    }

    public static String failRespWithMsg(String msg){
        JSONObject rsp = new JSONObject();
        rsp.put("respCode","9999");
        rsp.put("respDesc",msg);
        return rsp.toString();
    }
}
