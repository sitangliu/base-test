package com.ijianghu.lambda;

/**
 * @author kai
 * @date 2019/10/15
 * @desc base-test
 * lambda实现Runnable
 **/
public class RunnableTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Before java8,too much code for too little to do");
            }
        }).start();

        new Thread(()-> System.out.println("In java8,Labbda expression rocks")).start();
    }

}
