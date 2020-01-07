package com.ijianghu.socket.tcp.v0;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author kai
 * @date 2020/1/7
 * @desc base-test
 **/
public class TcpClient {

    public static void main(String[] args) throws IOException {
        System.out.println("-------TCPClient--------");
        //建立连接
        Socket client = new Socket("localhost", 8888);
        DataInputStream reader = new DataInputStream(client.getInputStream());
        String s = reader.readUTF();
        System.out.println(s);
        reader.close();
        client.close();
    }
}
