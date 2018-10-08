package org.stepic.java.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class checkSum {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        int read =0;
        while ((read = inputStream.read()) != -1){
            sum = Integer.rotateLeft(sum,1 )^read;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        InputStream stream = new ByteArrayInputStream( new byte[] { 0x33, 0x45, 0x01});
        System.out.println(checkSumOfStream(stream));
    }
}
