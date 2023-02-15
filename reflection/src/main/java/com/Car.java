package com;


/**
 * @Author Lianhk
 * @Description //TODO 车类
 * @Date 2023/2/12
 **/

public class Car {
    public String bander = "宝马";
    public Integer price = 500000;
    public String color = "白色";


    @Override
    public String toString() {
        return "Car{" +
                "bander='" + bander + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
    public void test(){
        System.out.println("test");
    }
}
