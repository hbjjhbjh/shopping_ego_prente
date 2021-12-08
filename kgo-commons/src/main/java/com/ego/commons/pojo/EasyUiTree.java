package com.ego.commons.pojo;


/*
* 二级菜单
* 显示树桩结构的工具类
* */
public class EasyUiTree {
    private long id; //节点Id
    private String text; //节点名称
    private String state; //节点状态 “open”，“closed”

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
