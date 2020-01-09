package com.ijianghu.socket.tcp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author kai
 * @date 2020/1/9
 * @desc base-test
 **/
public class Server {

    private static int port  = 9999;
    //1.建立一个多路复用器（管理所有的通道）
    private static Selector selector;
    //2.建立缓冲区
    private static ByteBuffer readBuf = ByteBuffer.allocate(1024);
    private static ByteBuffer writeBuf = ByteBuffer.allocate(1024);
    //创建临时会话介质
    private static Map<String,Object> msgMap = new HashMap<>(16);
    public static void main(String[] args) throws IOException {
        //1.打开多路复用器
        selector = Selector.open();
        //2、创建一个ServerSocket
//        ServerSocket serverSocket = new ServerSocket(port);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3、获取一个ServerSocketChannle,打开服务通道
        InetSocketAddress socketAddress = new InetSocketAddress("192.168.1.148",port);
        serverSocketChannel.bind(socketAddress);
//        ServerSocketChannel serverSocketChannel = serverSocket.getChannel();  //获取serverSocketChannel为空
        //4.设置服务通道为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //5、注册通道到多路复用选择器上,并且监听阻塞事件。这个channel一直在等待
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("------------Server start,port"+port+"----------------");

        while(true){
            //1.多路复用器开始监听。表示注册在多路复用器上的通道都在被监听
            selector.select();
            //2.返回多路复用器已经选择的结果集（每次循环都要遍历注册到selector上的所有key）
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            //3.进行遍历
            while(keys.hasNext()){
                //4.获取key并进行处理
                SelectionKey key = keys.next();
                //5.直接从容器中移除就可以了，因为这个操作已经在下面被处理完了，
                //如果之后channel中又有数据了，就需要重新注册
                keys.remove();
                //6.是否是有效的，比如Client与服务器端断掉了就不是有效的
                if(key.isValid()){
                    //7.如果为阻塞状态
                    if(key.isAcceptable())
                        accept(key);
                    if(key.isReadable())
                        read(key);
                    if(key.isWritable())
                        write(key);
                }
            }
        }
    }

    /**
     * 进行写操作
     * @param key
     */
    private static void write(SelectionKey key) throws IOException {
        //清空缓冲区旧的数据
        writeBuf.clear();
        //获取之前注册的socket通道对象
        SocketChannel socketChannel = (SocketChannel)key.channel();
        String msg = (String)msgMap.get(socketChannel.getRemoteAddress().toString()+socketChannel.socket().getPort());
        //创建数据数组
        writeBuf.put(("你好，我是电话员："+msg).getBytes());
        //向通道写入数据
        writeBuf.flip();
        socketChannel.write(writeBuf);
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    /**
     * 进行读操作
     * @param key
     */
    private static void read(SelectionKey key) throws IOException {
        //1.清空缓冲区旧的数据
        readBuf.clear();
        //2.获取之前注册的socket通道对象
        SocketChannel socketChannel = (SocketChannel) key.channel();
        //3.读取数据
        int read = socketChannel.read(readBuf);
        //4.如果没有数据,关闭连接
        if(read == -1){
            key.channel().close();
            key.cancel();
            return;
        }
        //5.有数据则进行读取，读取之前需要进行复位方法（把position和limit进行复位)
        readBuf.flip();
        //6.根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
        byte[] bytes = new byte[readBuf.remaining()];
        //7.接收缓冲区数据，将readBuf中的数据写到bytes中
        readBuf.get(bytes);
        //8.打印结果
        String msg = new String(bytes);
        System.out.println(socketChannel.getRemoteAddress()+" msg :"+ msg);
        //9.回写数据给客户端
        msgMap.put(socketChannel.getRemoteAddress().toString()+socketChannel.socket().getPort(),msg);
        socketChannel.register(selector,SelectionKey.OP_WRITE);
    }

    /**
     * 进行连接操作
     * @param key
     */
    private static void accept(SelectionKey key) throws IOException {

        //1.获取网络连接服务通道
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
        //2.执行阻塞方法。（等待客户端的通道是否注册上了）
        SocketChannel socketChannel = serverSocketChannel.accept();
        //3.设置非阻塞模式
        socketChannel.configureBlocking(false);
        SocketAddress remoteAddress = socketChannel.getRemoteAddress();
        System.out.println("已经与"+remoteAddress+"建立连接");
        //4.注册到多路复用器上，并设置读取标志
        socketChannel.register(selector,SelectionKey.OP_READ);

    }

}
