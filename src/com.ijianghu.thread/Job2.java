package com.ijianghu.thread;

/**
 * @author kai
 * @date 2019/10/9
 * @desc base-test
 **/
public class Job2 implements Runnable{

    public void run() {
        long start = System.currentTimeMillis();
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"运行了 "+(end - start)+" ms");
        }
    }

    public static void main(String[] args) {
        new Thread(new Job2()).start();
        new Thread(new Job2()).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在运行");
            }
        }).start();
    }
}
