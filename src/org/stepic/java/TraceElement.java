package org.stepic.java;

public class TraceElement {
        public static void main(String[] args) {
            System.out.println(getCallerClassAndMethodName());
            anotherMethod();
        }

        private static void anotherMethod() {
            System.out.println(getCallerClassAndMethodName());
        }

        public static String getCallerClassAndMethodName() {
            StackTraceElement [] thr = new Throwable().getStackTrace();
            if (thr.length >=3)
                return thr[2].getClassName() + "#" + thr[2].getMethodName();
            else
                return null;
        }
    }
