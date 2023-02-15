package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author Lianhk
 * @Description //TODO 使用反射创建对象练习
 * @Date 2023/2/14
 **/
public class ReflecCreateInstance {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //使用构造器创建对象。
        Class aClass = Class.forName("com.reflection.User");
        System.out.println(aClass);

        Class<Void> voidClass = void.class;
        Constructor<Void> constructor2 = voidClass.getConstructor();
        constructor2.setAccessible(true);
        Void unused = constructor2.newInstance();
        System.out.println(unused);

        //获取public无参构造器创建对象。
        Object o = aClass.newInstance();
        System.out.println(o);

        //调用类中public有参构造器创建对象。
        Constructor constructor = aClass.getConstructor(Integer.class);
        System.out.println(constructor.newInstance(123));

        //调用类中private有参构造。
        Constructor constructor1 = aClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);//爆破:让其可以使用非public构造器创建对象。
        System.out.println(constructor1.newInstance("张三丰"));
    }


}

class User {
    String name = "韩顺平";
    Integer age = 18;

    public User(){

    }

    public User(Integer age){
        this.age = age;
    }

    private User(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
