package com.kung.atom;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("T_BUSI_ORDERLOG")
public class OrderLog {
    String orderId;
    Date acceptDate ;

    public String getOrderMsg() {
        return orderMsg;
    }

    public void setOrderMsg(String orderMsg) {
        this.orderMsg = orderMsg;
    }

    String orderMsg ;
    String provinceCode;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
