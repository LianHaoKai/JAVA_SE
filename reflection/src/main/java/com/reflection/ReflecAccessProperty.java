package com.reflection;

import java.lang.reflect.Field;

/**
 * @Author Lianhk
 * @Description //TODO 通过属性访问对象。
 * @Date 2023/2/14
 **/
public class ReflecAccessProperty {
    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Property> propertyClass = Property.class;
        Property property = propertyClass.newInstance();
        //获取public Field.
        Field name = propertyClass.getField("name");
        name.set(property,"里斯");

        //获取private Field;
        Field age = propertyClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(property,123);

        //获取private static Field;
        Field sex = propertyClass.getDeclaredField("sex");
        sex.setAccessible(true);
        sex.set(property,"女");
        System.out.println(sex);

        //获取private final static Field;
        Field field = propertyClass.getDeclaredField("tel");
        field.setAccessible(true);
        field.set(null,123);
        System.out.println(field);


        System.out.println(property);
    }
}

class Property{
    public String name = "张三";
    private Integer age = 18;
    private static String sex = "男";
    private static Integer tel = 176;
    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
