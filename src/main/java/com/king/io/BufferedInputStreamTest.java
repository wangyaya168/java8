package com.king.io;
import java.io.*;
public class BufferedInputStreamTest {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:context.xml");
        BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
        byte[] aa = new byte[3];
        int readLength = inputStream.read(aa);
        System.out.println(readLength);
        System.out.println(aa[0]);
        System.out.println(new String(aa,0,readLength));
    }
}
