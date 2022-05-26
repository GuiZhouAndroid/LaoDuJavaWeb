package com.bjpowernode.template1;

public class Student {

    /**
     * 这个方法描述学生的一天
     */
    public void day(){
        // 和Teacher的算法相同。
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
        System.out.println("学生上学，学习");
    }

    public void chiWanFan(){
        System.out.println("吃晚饭");
    }

    public void shuiJiao(){
        System.out.println("睡觉");
    }

}
