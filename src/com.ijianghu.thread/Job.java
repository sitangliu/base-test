package com.ijianghu.thread;

import com.ijianghu.thread.localThread.SerialNum;

/**
 * @author kai
 * @date 2019/10/9
 * @desc base-test
 **/
public class Job extends Thread {
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = SerialNum.get();
            System.out.println(Thread.currentThread().getName()+"正在运行,当前local值："+i);
        }
    }

    public static void main(String[] args) {
        new Job().start();
        new Job().start();
    }
}
