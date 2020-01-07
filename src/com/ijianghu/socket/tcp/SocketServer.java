package com.ijianghu.socket.tcp;

import java.io.*;
import java.net.*;

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
                InputStream inputStream = client.getInputStream();
                BufferedReader buf = new BufferedReader(new InputStreamReader(inputStream));
                String readLine = buf.readLine();
                System.out.println(client.getInetAddress().getHostAddress()+":"+client.getPort()+"  "+readLine);
                OutputStream out = client.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                writer.write("hello"+readLine);
                writer.flush();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
