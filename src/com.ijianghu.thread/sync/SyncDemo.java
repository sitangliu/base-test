package com.ijianghu.thread.sync;

/**
 * @author kai
 * @date 2019/10/9
 * @desc 线程交互通信
 **/
public class SyncDemo {

    public static void main(String[] args) {

        final Business business = new Business();
        new Thread(new Runnable() {
            public void run() {
                for(int i = 0;i<3;i++){
                    business.subMethod();
                }
            }
        }).start();

        for(int i=0;i<3;i++){
            business.mainMethod();
        }
    }
}
