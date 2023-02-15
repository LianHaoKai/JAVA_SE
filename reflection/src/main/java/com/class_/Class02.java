package com.class_;

import com.Car;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Lianhk
 * @Description //TODO 反射基础练习
 * @Date 2023/2/12
 * @Param 
 * @return 
 **/
public class Class02 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        String classPath = "com.Car";

        //获取类
        Class<?> cla = Class.forName(classPath);
        //获取类名
        System.out.println(cla.getName());
        //获取运行时类
        System.out.println(cla.getClass());
        //获取对象
        Object o = cla.newInstance();
        System.out.println(o);
        //获取属性
        Field bander = cla.getField("bander");
        System.out.println(bander.get(o));
        //修改对象
        bander.set(o,"奔驰");
        System.out.println(o);
        //输出所有属性
        Field[] fields = cla.getFields();
        for (Field field : fields) {
            System.out.println(field.get(o));
        }
        //调用方法
        Method test = cla.getMethod("test", null);
        test.invoke(o,null);

    }
}
