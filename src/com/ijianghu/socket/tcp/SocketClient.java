//package com.ijianghu.socket.tcp;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.net.SocketAddress;
//
///**
// * @author kai
// * @date 2020/1/6
// * @desc base-test
// **/
//public class SocketClient {
//
//    public static void main(String[] args) {
//        try{
//            //创建一个客户端Socket连接
//            Socket client = new Socket("192.168.1.148", 9999);
//            //设置超时时间
//            client.setSoTimeout(100000);
//            //获取键盘输入
//            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//            //获取Socket的输出流，用来发送数据到服务端
//            PrintStream output = new PrintStream(client.getOutputStream());
//            //获取Socket的输入流，用来接收从服务端发送过来的数据
//            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
//
//            boolean flag = true;
//            while (flag){
//                System.out.println("请输入信息");
//                String msgLine = input.readLine();
//                output.println(msgLine);
//                if("bye".equals(msgLine)){
//                    flag = false;
//                }else{
//                    String infoLine = buf.readLine();
//                    System.out.println(infoLine);
//                }
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//}
