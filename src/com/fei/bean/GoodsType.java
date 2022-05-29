package com.fei.bean;

public class GoodsType {
    private int id;
    private String typeName;
    private Integer level;
    private Integer pid;

    public GoodsType() {
    }

    public GoodsType(String typeName) {
        this.typeName = typeName;
    }

    public GoodsType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public GoodsType(int id, String typeName, Integer level, Integer pid) {
        this.id = id;
        this.typeName = typeName;
        this.level = level;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", level=" + level +
                ", pid=" + pid +
                '}';
    }
}
