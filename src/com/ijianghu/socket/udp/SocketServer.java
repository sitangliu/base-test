package com.ijianghu.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author kai
 * @date 2020/1/6
 * @desc base-test
 **/
public class SocketServer {

    private static Integer port = 9999;

    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket(port);
            DatagramPacket request = new DatagramPacket(new byte[1024], 0, 1014);
            while(true){
                socket.receive(request);
                byte[] data = request.getData();
                InetAddress address = request.getAddress();
                String msg = new String(data);
                System.out.println(address.getHostAddress()+":"+request.getPort()+"::"+msg);
                String answer  =  "你好："+msg;
                System.out.println("local:"+answer);
                DatagramPacket response = new DatagramPacket(answer.getBytes(), answer.getBytes().length, address, request.getPort());
                socket.send(response);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
