package com.keg.item.pojo;

import java.util.List;

//将菜单中的数据，封装到该类中
public class PortalMenu {
    //把前端所有数据，存放在data对象中
    private List<Object> data;

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
