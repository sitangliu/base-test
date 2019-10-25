package com.ijianghu.classloader;

/**
 * @author kai
 * @date 2019/10/24
 * @desc base-test
 **/
public class PingDemo {

    public static void main(String[] args) {
        int drink = 0;
        int drinkEmpyt = 0;
        for(int i=0;i<20;i++){
            drink++;
            drinkEmpyt++;
            if(drinkEmpyt%2==0){
                drink++;
                drinkEmpyt++;
            }
        }
        System.out.println(drink);
    }

}
