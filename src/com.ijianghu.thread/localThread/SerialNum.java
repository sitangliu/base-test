package com.ijianghu.thread.localThread;

/**
 * @author kai
 * @date 2019/10/9
 * @desc base-test
 **/
public class SerialNum {

    private static int nextSerialNum = 0;

    private static ThreadLocal serialNum = new ThreadLocal(){

        @Override
        protected Object initialValue() {
            return new Integer(nextSerialNum++);
        }
    };

    public static int get(){
        return ((Integer)(serialNum.get())).intValue();
    }

}
