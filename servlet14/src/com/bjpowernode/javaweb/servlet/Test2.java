package com.bjpowernode.javaweb.servlet;

public class Test2 {

    // 静态代码块，在类加载时执行，并且只执行一次。
    // 这个语法很简单，静态代码块什么时候用？这是困扰大家的一个问题。
    // 静态代码块用的实际上不多。但偶尔要用一下。什么时候用呢？
    // 那要看具体的需求，你是否需要在类加载时机去执行一段代码，如果有需要，就可以把这个代码写入静态代码块，到时候自然就执行了。
    // 静态代码块就是java语言为java程序员预留的一个特殊的时机，这个时机叫做：类加载时机。
    static {
        System.out.println("类加载了。");
    }

    // 入口
    public static void main(String[] args) {

    }
}
