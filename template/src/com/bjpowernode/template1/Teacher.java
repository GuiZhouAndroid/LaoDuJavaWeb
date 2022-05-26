package com.bjpowernode.template1;

/**
 * 存在的问题：
 *      第一：算法没有得到重复的使用。
 *      第二：代码没有得到复用。
 */
public class Teacher {
    /**
     * 这个方法描述老师的一天
     */
    public void day(){
        // 和Student的算法相同。
        qiChuang();
        xiShu();
        chiZaoCan();
        doSome();
        chiWanFan();
        shuiJiao();
    }

    public void qiChuang(){
        System.out.println("起床");
    }

    public void xiShu(){
        System.out.println("洗漱");
    }

    public void chiZaoCan(){
        System.out.println("吃早餐");
    }

    public void doSome(){
        System.out.println("老师正在课堂上授课，教授学生知识");
    }

    public void chiWanFan(){
        System.out.println("吃晚饭");
    }

    public void shuiJiao(){
        System.out.println("睡觉");
    }
}
