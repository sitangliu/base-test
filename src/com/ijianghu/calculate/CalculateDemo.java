package com.ijianghu.calculate;

/**
 * @author kai
 * @date 2019/12/17
 * @desc base-test
 **/
public class CalculateDemo {
    private String name = "jiQi1hao";
    private int age = 100;

    private static String company = "iJiangHu";

    private static final String owner = "Kai";

    public static int cal(int op1,int op2){
        op1 = 5;
        int op3 = op1+op2;
        return op3;
    }

    public static void say(){
        System.out.println("calculate complete");
    }

    public static void main(String[] args) {
        int cal = cal(2, 4);
        System.out.println(cal);
        say();
    }
}
