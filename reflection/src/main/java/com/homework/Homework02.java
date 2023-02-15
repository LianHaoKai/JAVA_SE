package com.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Lianhk
 * @Description //TODO 练习二
 * @Date 2023/2/15
 **/
public class Homework02 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("java.io.File");
        Constructor<?>[] constructor = aClass.getDeclaredConstructors();
        for (Constructor<?> constructor1 : constructor) {
            System.out.println(constructor1);
        }

        //获取对象
        Constructor<?> constructor1 = aClass.getConstructor(String.class);
        Object o = constructor1.newInstance("d:\\mynew.txt");

        //获取方法
        Method createNewFile = aClass.getDeclaredMethod("createNewFile");
        Object invoke = createNewFile.invoke(o);
        System.out.println(invoke);
    }
}
