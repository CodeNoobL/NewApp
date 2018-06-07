package com.example.administrator.newapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class Util {
    public static  String stream2String(InputStream is) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(50);
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len=is.read(buffer)) != -1){
            byteArrayOutputStream.write(buffer,0,len);
        }
        return  byteArrayOutputStream.toString();
    }
}
