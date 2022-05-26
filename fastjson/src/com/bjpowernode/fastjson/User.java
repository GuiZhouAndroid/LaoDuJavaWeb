package com.bjpowernode.fastjson;

/**
 * @program: 代码
 * @ClassName: User
 * @version: 1.0
 * @description: 用户类
 * @author: bjpowernode
 * @create: 2022-05-14 18:13
 **/
public class User {
    private String id;
    private String username;
    private int age;

    public User() {
    }

    public User(String id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
