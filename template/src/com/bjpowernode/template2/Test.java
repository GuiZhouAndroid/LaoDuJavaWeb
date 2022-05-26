package com.bjpowernode.template2;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Teacher();
        p1.day();
        System.out.println("-----------------");
        Person p2 = new Student();
        p2.day();
    }
}
