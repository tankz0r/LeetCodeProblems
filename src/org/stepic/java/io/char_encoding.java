package org.stepic.java.io;


import java.io.InputStream;
import java.util.Scanner;

public class char_encoding {
    public static void main(String[] args) {
        InputStream in = System.in;
        String next;
        double sum = 0;
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()){
            next = scanner.next();
            try{
                sum += Double.parseDouble(next);
            }
            catch (NumberFormatException e){};
        }
        System.out.format("%.6f",sum);
    }
}
