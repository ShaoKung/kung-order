package com.kung.atom;

import java.util.Date;

public class Order {

    String orderId;
    String provinceCode;
    String city;
    String district;
    String address ;
    String phone ;
    Double commPrice ;
    Integer commCount;
    String commId;
    String postId;

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

    Date orderTime ;

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
