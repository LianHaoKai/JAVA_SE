package com.class_;

import java.io.Serializable;

public class AllTypeClass {

    public static void main(String[] args) {
        Class<Car> cls1 = Car.class;//获取内部类
        Class<int[]> cls2 = int[].class;//获取数组类
        Class<int[][]> cls3 = int[][].class;//获取二维数组。
        Class<Integer> cls4 = int.class;//获取基本类型。
        Class<Deprecated> cls5 = Deprecated.class;//获取注解的类。
        Class<Thread.State> cls6 = Thread.State.class;//获取enum的类
        Class<Void> cls7 = void.class;//获取void的类
        Class<Serializable> cls8 = Serializable.class;//获取接口的类
        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);

    }

    private class Car{
        String name = "花猫";

        public void say(){
            System.out.println(name+"喵喵喵...");
        }
    }
}