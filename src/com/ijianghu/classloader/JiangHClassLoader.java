package com.ijianghu.classloader;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Properties;

/**
 * @author kai
 * @date 2019/10/24
 * @desc base-test
 **/
public class JiangHClassLoader extends ClassLoader{
    private String classpath;

    public JiangHClassLoader(String classpath){
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //获取class文件
        //利用StringBuilder将包形式的类型转化为unix形式的路径

        StringBuilder sb = new StringBuilder(classpath);
        sb.append("/").append(name.replace(".","/")).append(".class");
        String filenName = sb.toString();

        //将class文件已数组流的形式读入到内存
        byte[] classbyte = null;

            //根据class文件获取字节数组
            Properties properties = System.getProperties();
            String filePath = (String)properties.get("user.dir");

        FileInputStream fileInput = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            fileInput = new FileInputStream(filenName);
            FileChannel channel = fileInput.getChannel();

            WritableByteChannel byteChannel = Channels.newChannel(outputStream);
            //指定一个固定长度的buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int flag;
            while((flag=channel.read(buffer))!=-1){
                if(flag == 0) break;
                buffer.flip();
                byteChannel.write(buffer);
                buffer.clear();
            }
            fileInput.close();
            channel.close();
            byteChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        classbyte = outputStream.toByteArray();

        //利用自身的加载器加载类
        Class<?> retClass = defineClass(null, classbyte, 0, classbyte.length);
        if(retClass != null){
            System.out.println("由我加载");
            return retClass;
        }


        System.out.println("非我加载");
        //在classPath中找不到类文件，委托给父类加载器，父类返回null,因为可加载的话在委派的过程中就已经被加载了。
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        JiangHClassLoader jiangHClassLoader = new JiangHClassLoader("d:/com/path/test");
        Class<?> helloDemo = jiangHClassLoader.loadClass("HelloDemo");
        Object instance = helloDemo.newInstance();


    }

}
