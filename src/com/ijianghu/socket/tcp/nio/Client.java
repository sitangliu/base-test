package com.ijianghu.socket.tcp.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author kai
 * @date 2020/1/9
 * @desc base-test
 **/
public class Client {

    private static int port = 9999;
    private static String dnsName = "www.ijianghu.chat";
    //建立缓冲区
    private static ByteBuffer readBuf = ByteBuffer.allocate(1024);
    private static ByteBuffer writeBuf = ByteBuffer.allocate(1024);
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName(dnsName);
        SocketChannel socketChannel = SocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.1.148",port);
        socketChannel.connect(inetSocketAddress);
        /*Socket socket = new Socket("192.168.1.148", port);
        SocketChannel socketChannel = socket.getChannel();*/
        //设置通道为非阻塞模式
        socketChannel.configureBlocking(false);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean flag= true;
        while (flag){
            readBuf.clear();
            socketChannel.read(readBuf);
            readBuf.flip();
            if(readBuf.remaining() != 0){
                byte[] bytes = new byte[readBuf.remaining()];
                readBuf.get(bytes);
                System.out.println("收到消息"+new String(bytes));
            }
            System.out.println("请输入消息：");
            String line = input.readLine();
            writeBuf.clear();
            writeBuf.put(line.getBytes());
            writeBuf.flip();
            socketChannel.write(writeBuf);
        }
    }

}
