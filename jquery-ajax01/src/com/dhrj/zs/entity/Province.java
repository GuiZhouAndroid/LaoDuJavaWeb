package com.dhrj.zs.entity;

public class Province {

    private Integer id;
    private String name;
    private String jiancheng;


    public Province() {
    }

    public Province(Integer id, String name, String jiancheng, String shenghui) {
        this.id = id;
        this.name = name;
        this.jiancheng = jiancheng;
        this.shenghui = shenghui;
    }

    private String shenghui;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJiancheng() {
        return jiancheng;
    }

    public void setJiancheng(String jiancheng) {
        this.jiancheng = jiancheng;
    }

    public String getShenghui() {
        return shenghui;
    }

    public void setShenghui(String shenghui) {
        this.shenghui = shenghui;
    }


    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jiancheng='" + jiancheng + '\'' +
                ", shenghui='" + shenghui + '\'' +
                '}';
    }
}
