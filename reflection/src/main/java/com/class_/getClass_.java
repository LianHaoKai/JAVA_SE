package com.class_;

import com.Car;

import java.lang.reflect.Field;

/**
 * @Author Lianhk
 * @Description //TODO 演示得到Class对象的各种方式
 * @Date 2023/2/12
 **/
public class getClass_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {


        //四种类加载方式
        //1. Class.forName(类名)
        Class<?> aClass = Class.forName("com.Car");
        Object o = aClass.newInstance();
        Field bander1 = aClass.getField("bander");
        System.out.println(bander1.get(o));
        //2. 类加载器
        Car car = new Car();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Field bander2 = classLoader.loadClass("com.Car").getField("bander");
        System.out.println(bander2.get(o));

        //3. 类名.calss
        Field bander3 = Car.class.getField("bander");
        System.out.println(bander3.get(o));
        //5. 类加载
        Field bander4 = car.getClass().getField("bander");
        System.out.println(bander4.get(o));
    }
}
