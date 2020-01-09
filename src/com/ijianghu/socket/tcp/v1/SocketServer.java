package com.ijianghu.socket.tcp.v1;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kai
 * @date 2020/1/6
 * @desc base-test
 **/
public class SocketServer {

    public static void main(String[] args) {
        try{

            ServerSocket serverSocket = new ServerSocket(9999);
            //设置监听端口
            Socket client = null;
            boolean f = true;
            while(f){
                client = serverSocket.accept();
                System.out.println("与"+client.getInetAddress().getHostAddress()+":"+client.getPort()+" 已建立连接");
                new Thread(new ServerThread(client)).start();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
