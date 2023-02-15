package com.question;

import demo.Cat;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflection01 {

    public static void main(String[] args) {
//        System.out.println(new Reflection01().getClass().getName());
        m1();
    }

    /**
     * @Author Lianhk
     * @Description //TODO 通过反射访问属性。
     * @Date 2023/2/11
     * @Param []
     * @return void
     **/
    
    private static void m1(){
        try {
            Class<?> aClass = Class.forName("demo.Cat");
            Field fields = aClass.getField("name");
            fields.setAccessible(true);
            Cat o = (Cat) aClass.newInstance();
            o.setName("猫");
            System.out.println(fields.get(o));
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
