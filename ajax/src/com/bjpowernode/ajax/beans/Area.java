package com.bjpowernode.ajax.beans;

/**
 * @program: 代码
 * @ClassName: Area
 * @version: 1.0
 * @description: 区域
 * @author: bjpowernode
 * @create: 2022-05-15 22:02
 **/
public class Area {
    private String code;
    private String name;

    public Area() {
    }

    public Area(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
