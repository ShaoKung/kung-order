package com.kung.atom;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("T_BUSI_POSTINFO")
public class OrderPost implements Serializable {
    @TableField("ORDER_ID")
    String orderId;
    @TableField("POST_ID")
    String postId;
    @TableField("POST_ADDRESS")
    String postAddress ;
    @TableField("CHECKED")
    String checked;
    @TableField("CHECK_STAFF")
    String checkStaff;
    @TableField("COLLECT_STAFF")
    String collectStaff;
    @TableField("COLLECT_TIME")
    Date collectTime;
    @TableField("WEIGHT")
    double weight;
    @TableField("FROM_PROV")
    String fromProv;
    @TableField("FROM_CITY")
    String fromCity;
    @TableField("FROM_DIST")
    String fromDist;
    @TableField("FROM_ADDR")
    String fromAddr;
    @TableField("DEST_PROV")
    String destProv;
    @TableField("DEST_CITY")
    String destCity;
    @TableField("DEST_DIST")
    String destDist;
    @TableField("DEST_ADDR")
    String destAddr;
    @TableField("RECE_NAME")
    String receName;
    @TableField("RECE_PHON")
    String recePhon;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getCheckStaff() {
        return checkStaff;
    }

    public void setCheckStaff(String checkStaff) {
        this.checkStaff = checkStaff;
    }

    public String getCollectStaff() {
        return collectStaff;
    }

    public void setCollectStaff(String collectStaff) {
        this.collectStaff = collectStaff;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getFromProv() {
        return fromProv;
    }

    public void setFromProv(String fromProv) {
        this.fromProv = fromProv;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromDist() {
        return fromDist;
    }

    public void setFromDist(String fromDist) {
        this.fromDist = fromDist;
    }

    public String getFromAddr() {
        return fromAddr;
    }

    public void setFromAddr(String fromAddr) {
        this.fromAddr = fromAddr;
    }


    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getRecePhon() {
        return recePhon;
    }

    public void setRecePhon(String recePhon) {
        this.recePhon = recePhon;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDestProv() {
        return destProv;
    }

    public void setDestProv(String destProv) {
        this.destProv = destProv;
    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public String getDestDist() {
        return destDist;
    }

    public void setDestDist(String destDist) {
        this.destDist = destDist;
    }

    public String getDestAddr() {
        return destAddr;
    }

    public void setDestAddr(String destAddr) {
        this.destAddr = destAddr;
    }
}
