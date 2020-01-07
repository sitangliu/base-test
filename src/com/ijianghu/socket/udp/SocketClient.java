package com.ijianghu.socket.udp;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author kai
 * @date 2020/1/6
 * @desc base-test
 **/
public class SocketClient {

    private Integer port;
    private static Integer remotePort = 9999;

    public static void main(String[] args) {
        try{
            //客户端使用随机端口
            DatagramSocket socket = new DatagramSocket();
            //设置一个连接超时时间
            socket.setSoTimeout(1000);
            InetAddress host = InetAddress.getLocalHost();
            //建立数据包，一个发送数据包，一个接收数据包
            while(true){
                byte[] write = new byte[8];
                System.in.read(write);

                //发送数据包
                DatagramPacket request = new DatagramPacket(write, write.length, host, remotePort);

                //接收数据包
                byte[] bytes = new byte[1024];
                DatagramPacket response = new DatagramPacket(bytes, bytes.length);
                socket.send(request);
                socket.receive(response);
                byte[] data = response.getData();
                System.out.println(response.getAddress().getHostAddress()+":"+response.getPort()+" ::"+new String(data));
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
