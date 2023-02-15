package demo;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

public class demo01 {

    public static void main(String[] args) {

        try {
            System.out.println();
            Properties pro = new Properties();
            URL resource = new demo01().getClass().getResource("/re.properties");
            pro.load(new FileInputStream(resource.getPath()));
            String classfullpath = pro.getProperty("classfullpath");
            String method = pro.getProperty("method");
            Class aclass = Class.forName(classfullpath);
            Method method1 = aclass.getMethod(method);
            method1.invoke(aclass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
