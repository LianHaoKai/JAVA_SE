package com.homework;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.homework.PrivateTest");
        //创建对象
        Object o = aClass.newInstance();
        //获取Field
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"hello");
        //获取方法
        Method getName = aClass.getMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);
    }
}

class PrivateTest{
    private String name = "HelloKitty";
    public String getName(){
        return name;
    }}