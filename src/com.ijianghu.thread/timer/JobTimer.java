package com.ijianghu.thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author kai
 * @date 2019/10/9
 * @desc base-test
 **/
public class JobTimer {

    private static int count = 0;

    public static void main(String[] args) {
        class TimerTaskCus extends TimerTask{
            public void run() {
                count = (count+1)%2;
                System.err.println("Boob boom");
                new Timer().schedule(new TimerTaskCus(),2000+2000*count);
            }
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTaskCus(),2000+2000*count);

        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
