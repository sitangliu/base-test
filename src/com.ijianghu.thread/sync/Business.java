package com.ijianghu.thread.sync;

/**
 * @author kai
 * @date 2019/10/9
 * @desc base-test
 **/
public class Business {

    private boolean subFlag = true;

    protected synchronized void mainMethod(){
        while (true){
            if(subFlag == true){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+":main thread running loop count --"+i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            subFlag = true;
            notify();
        }
    }

    protected synchronized void subMethod(){
        while (true){
            if(subFlag != true){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+":sub thread running loop count --"+i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            subFlag = false;
            notify();
        }
    }

}
