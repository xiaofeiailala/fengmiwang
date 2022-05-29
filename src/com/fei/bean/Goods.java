package com.fei.bean;

import java.sql.Date;

public class Goods{
    private int id;
    private String goodsName;
    private Double price;
    private Integer score;
    private Date deployDate;
    private String imgPath;
    private String comment;
    private Integer typeId;
    private String typeName;

    public Goods() {
    }

    public Goods(int id, String goodsName, Double price, Integer score, Date deployDate, String imgPath, String comment, Integer typeId) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.score = score;
        this.deployDate = deployDate;
        this.imgPath = imgPath;
        this.comment = comment;
        this.typeId = typeId;
    }

    public Goods(int id, String goodsName, Double price,Integer typeId, String imgPath, String comment) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.imgPath = imgPath;
        this.comment = comment;
        this.typeId = typeId;
    }
//    public Goods(int id, String goodsName, Double price, Integer score, Date deployDate, String imgPath, String comment, Integer typeId, String typeName) {
//        this.id = id;
//        this.goodsName = goodsName;
//        this.price = price;
//        this.score = score;
//        this.deployDate = deployDate;
//        this.imgPath = imgPath;
//        this.comment = comment;
//        this.typeId = typeId;
//        this.typeName = typeName;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Date deployDate) {
        this.deployDate = deployDate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", score=" + score +
                ", deployDate=" + deployDate +
                ", imgPath='" + imgPath + '\'' +
                ", comment='" + comment + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
