package com.ijianghu.socket.tcp.v1;

import java.io.*;
import java.net.Socket;

/**
 * @author kai
 * @date 2020/1/7
 * @desc base-test
 **/
public class ServerThread implements Runnable {
    private Socket client;
    public ServerThread(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        try{
            InputStream inputStream = client.getInputStream();
            BufferedReader buf = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter  writer = new PrintWriter (new OutputStreamWriter(client.getOutputStream()),true);
            boolean flag = true;
            while (flag){
                String readLine = buf.readLine();
                System.out.println(client.getInetAddress().getHostAddress()+":"+client.getPort()+"  "+readLine);
                if(readLine.equals("bye")){
                    flag = false;
                }else{
//                    writer.write("hello"+readLine); //write并没有返回消息
                    writer.println("hello："+readLine);
//                    writer.flush();
                }
            }

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
