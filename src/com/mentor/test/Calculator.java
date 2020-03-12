package com.mentor.test;



public class Calculator {

    public static int calculator(int a, String operation, int b) {
        int res = 0;

            if (operation.equals("+")) {
                res = (a + b);
            } else if (operation.equals("-")) {
                res = (a - b);
            } else if (operation.equals("*")) {
                res = (a * b);
            } else if (operation.equals("/")) {
                res = (a / b);
            }
            return res;

    }
}


