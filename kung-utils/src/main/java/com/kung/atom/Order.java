package com.kung.atom;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

@TableName("T_BUSI_ORDER")
public class Order implements Serializable {

    @TableField("ORDER_ID")
    String orderId;
    @TableField("PROVINCE_CODE")
    String provinceCode;
    @TableField("CITY")
    String city;
    @TableField("DISTRICT")
    String district;
    @TableField("ADDRESS")
    String address ;
    @TableField("PHONE")
    String phone ;
    @TableField("COMM_PRICE")
    Double commPrice ;
    @TableField("COMM_COUNT")
    Integer commCount;
    @TableField("COMM_ID")
    String commId;
    @TableField("POST_ID")
    String postId;
    @TableField("ORDER_TIME")
    Date orderTime ;
    @TableField("EXT_ORDER_ID")
    String extOrderId ;

    public String getExtOrderId() {
        return extOrderId;
    }

    public void setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
    }

    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
        this.commId = commId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getCommPrice() {
        return commPrice;
    }

    public void setCommPrice(Double commPrice) {
        this.commPrice = commPrice;
    }

    public Integer getCommCount() {
        return commCount;
    }

    public void setCommCount(Integer commCount) {
        this.commCount = commCount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", commPrice=" + commPrice +
                ", commCount=" + commCount +
                ", commId='" + commId + '\'' +
                ", postId='" + postId + '\'' +
                ", orderTime=" + orderTime +
                '}';
    }
}
