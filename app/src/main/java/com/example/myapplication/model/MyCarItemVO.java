package com.example.myapplication.model;

public class MyCarItemVO {

    private int num;
    private String name;
    private String url;

    public MyCarItemVO(int num, String name, String url) {
        this.num = num;
        this.name = name;
        this.url = url;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }
}
