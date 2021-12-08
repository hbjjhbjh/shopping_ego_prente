package com.keg.item.pojo;

import java.util.List;

/*
* 把所有子菜单的数据封装到该类中
* */
public class PortalMenuNode {
    private String u;
    private String n;
    private List<Object> i;

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public List<Object> getI() {
        return i;
    }

    public void setI(List<Object> i) {
        this.i = i;
    }
}
