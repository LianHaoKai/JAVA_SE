package com.qihh.page02;


public class concurrencyTest {


    //循环次数
    private static final long count = 10000000;


    /*
     * @Author Lianhk
     * @Description 线程速度测试
     * @Date 2022/11/14
     * @Param [java.lang.String[]]
     * @return void
     **/
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        single();
    }

    //多线程
    private static void concurrency() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long k
            }
        });
        long g = 1;
        for (int j = 0; j < count; j++) {
            g++;
        }
        thread.join(); = 1;
                for (int i = 0; i < count; i++) {
                   k++;
                }
        long endTime = System.currentTimeMillis();
        System.out.println("concurrency:"+(endTime-startTime)+",g="+g);
    }

    //单线程
    private static void single(){
        long startTime = System.currentTimeMillis();
        long k = 1;
        for (int j = 0; j < count; j++) {
            k++;
        }

        long g = 1;
        for (int j = 0; j < count; j++) {
            g++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("single:"+(endTime-startTime)+",g="+g);
    }



}
