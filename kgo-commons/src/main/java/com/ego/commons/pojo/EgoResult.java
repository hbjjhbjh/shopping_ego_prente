package com.ego.commons.pojo;

import java.io.Serializable;
/*
* 用于“上架”,“下架”,“删除”的返回值类型的一个工具类
* */
public class EgoResult implements Serializable {
    private int status; //状态

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
