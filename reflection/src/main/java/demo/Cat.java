package demo;

public class Cat {

    public String name = "招财猫";

    int a = 1;
    static int b = 2;
    static final int c = 3;


    public static void main(String[] args) throws InstantiationException,IllegalAccessException {
        Class<Test> testClass = Test.class;
        Test test = testClass.newInstance();
        Test test2 = testClass.newInstance();
//        Test.say();

    }

    static {
//        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public void say(){
        System.out.println("喵...");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class Test{
    static {
        System.out.println("执行静态代码块");
    }
    public static void say(){
        System.out.println("静态方法");
    }
    Test(){
        System.out.println("构造方法");
    }
}