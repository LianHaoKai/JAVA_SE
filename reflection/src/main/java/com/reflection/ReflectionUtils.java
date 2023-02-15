package com.reflection;

import com.sun.deploy.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {


    public static void main(String[] args) throws ClassNotFoundException {
        api_02();
    }

    /**
     * @Author Lianhk
     * @Description //TODO 通过反射获取类的结构信息
     * @Date 2023/2/13
     **/
    public static void api_01() throws ClassNotFoundException {
        Class a = Class.forName("com.reflection.A");
        //1.获取全类名
        System.out.println(a.getName());
        //2.获取类名。
        System.out.println(a.getSimpleName());
        //3.获取所有public修饰的属性，包含本类及父类的。
        Field[] fields = a.getFields();
        for (Field field : fields) {
            System.out.println("父类及本类公开属性="+field.getName());
        }
        //4.获取本类中所有属性
        Field[] declaredFields = a.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("获取所有属性="+field.getName());
        }
        //5.获取所有public修饰的方法，包含本类以及父类的。
        Method[] methods = a.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类所有方法="+method.getName());
        }
        //6.获取本类中所有方法。
        Method[] declaredMethods = a.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类所有方法="+declaredMethod.getName());
        }
        //7.获取所有本类的public修饰的构造器。
        Constructor[] constructors = a.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("获取本类的public构造器="+constructor.getName());
        }
        //8.获取本类中所有的构造器。
        Constructor[] declaredConstructors = a.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
        //9.以Package形式返回 包信息。
        Package aPackage = a.getPackage();
        System.out.println("获取包信息="+aPackage);
        //10.以Class形式返回父类信息。
        Class superclass = a.getSuperclass();
        System.out.println("获取父类="+superclass.getName());
        //11.以Class[]形式返回接口信息。
        Class[] interfaces = a.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
        //12.以Annotation[]形式返回注解信息。
        Annotation[] annotations = a.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
    /**
     * @Author Lianhk
     * @Description //TODO 根据反射获取方法结构
     * @Date 2023/2/14
     **/
    public static void api_02(){
        //获取类对象
        Class a = A.class;
        Method[] declaredMethods = a.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            String name = declaredMethod.getName();

            int modifiers = declaredMethod.getModifiers();
            String s = String.format("%5s",Integer.toBinaryString(modifiers)).replaceAll(" ","0");
            char[] chars = s.toCharArray();
            String modifierBef = "" ;
            String modifierAft = "" ;
            for (int i = 0; i <5; i++) {
                if(chars[i] == '1' ){
                    switch (i){
                        case 4: modifierBef+="public ";
                            break;
                        case 3 : modifierBef+="private ";
                            break;
                        case 2 : modifierBef+="protected ";
                            break;
                        case 1 : modifierAft+="static ";
                            break;
                        case 0 : modifierAft+="find ";
                            break;
                    }
                }
            }

            Class<?> returnType = declaredMethod.getReturnType();
            String returnVar = returnType.getSimpleName()+" ";

            Class[] parameterTypes = declaredMethod.getParameterTypes();
            String params = "";
            for (Class parameterType : parameterTypes) {
                params += " "+parameterType.getSimpleName()+" ,";
            }
            if (params.endsWith(",")){
                params = params.substring(0,params.length()-1);
            }

            System.out.println(modifierBef+modifierAft+returnVar+name+"("+params+"){}");


        }
        return;
    }
}

@Deprecated
class A extends B implements C{
    private int a = 10;
    protected int b = 20;
    int c = 30;
    public int d = 40;

    private A(){

    }

    public A(String a){
    }

    private int ma( String name, String age){
        System.out.println("a1");
        return 1;
    }
    protected  void mb(){
        System.out.println("a2");
    }
     protected final static void mc(Boolean f){
        System.out.println("a3");
    }
    public final void md(){
        System.out.println("a4");
    }

}

class B{
    public String publcitB = "publcitB";
    private String privateB = "privateB";

    public B(){
        System.out.println("B类构造器");
    }
}

interface C{
    String publcitC = "publcitC";
}