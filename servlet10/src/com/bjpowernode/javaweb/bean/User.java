package com.bjpowernode.javaweb.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * 1. 一个普通的javabean
 * 2. 什么是javabean？
 *  java是咖啡。
 *  bean是豆子。
 *  javabean：咖啡豆。
 *  咖啡是由咖啡豆研磨而成。寓意是Java程序是由一个一个的Javabean组成的。
 *
 * 3. 一个JavaBean一般是有规范的：
 *      有无参数的构造方法
 *      属性私有化
 *      对外提供setter和getter方法
 *      重写toString()
 *      重写hashCode + equals
 *      实现java.io.Serializable接口。
 */
public class User implements Serializable {
    private String id;
    private String name;

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
