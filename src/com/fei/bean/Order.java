package com.fei.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Order {
    private int id;
    private String orderCode;
    private Double totalPrice;
    private Timestamp createDate;
    private Integer uid;
    private Integer status;
    private String username;
    private String orderStatus;

    public Order() {
    }

    public Order(int id, String orderCode, Double totalPrice, Timestamp createDate, Integer uid, Integer status, String username, String orderStatus) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
        this.uid = uid;
        this.status = status;
        this.username = username;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", createDate=" + createDate +
                ", uid=" + uid +
                ", status=" + status +
                ", username='" + username + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
