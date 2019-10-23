package com.ijianghu.lambda;

import cn.hutool.core.codec.Base64;

/**
 * @author kai
 * @date 2019/10/16
 * @desc base-test
 **/
public class Base64Test {

    public static void main(String[] args) {
        String encode = Base64.encode("http://192.168.1.59:80/base/sign/scan");
        System.out.println(encode);


    }
}
