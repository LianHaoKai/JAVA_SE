package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Lianhkcha
 * @Description //TODO 放射调用方法。
 * @Date 2023/2/15
 **/
public class ReflecAccessMethod {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.reflection.Boss");
        //调用静态方法。
        Method say = aClass.getMethod("say", String.class, int.class, char.class);
        Object invoke = say.invoke(null, "str", 1, 'c');

        //调用私有方法。
        Method say1 = aClass.getDeclaredMethod("hi");
        say1.setAccessible(true);//爆破
        Object invoke1 = say1.invoke(aClass.newInstance());
        System.out.println(invoke1);

    }

}

class Boss{
    String name ;
    Integer age;

    public static void say(String str,int i,char c){
        System.out.println(str+" "+i+" "+c);
    }

    private void hi(){
        System.out.println("hi");
    }
}