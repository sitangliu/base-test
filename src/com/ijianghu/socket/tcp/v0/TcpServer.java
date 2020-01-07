package com.ijianghu.socket.tcp.v0;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kai
 * @date 2020/1/7
 * @desc base-test
 **/
public class TcpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-------TCPServer--------");
        ServerSocket server = new ServerSocket(8888);

        // 阻塞式的等待连接
        Socket client = server.accept();
        DataOutputStream writer = new DataOutputStream(client.getOutputStream());
        writer.writeUTF("成功建立连接");
        writer.flush();
        writer.close();
        client.close();
        server.close();
        // server.close();

    }
}
