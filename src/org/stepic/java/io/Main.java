package org.stepic.java.io;

import java.io.*;

public class Main {
    protected static PrintStream out = System.out;
    protected static InputStream in = System.in;

    public static void main(String[] args) throws IOException{
//            System.setIn(new ByteArrayInputStream(new byte[] {65, 13, 10, 10, 13}));
            int prev = in.read();
            int next = 0;
            if (prev != -1) {
                while ((next = in.read()) != -1) {
                    if ((prev != 13) || (next != 10)) {
                        out.write(prev);
                        prev = next;
                    }
                }
            }
    }
}
