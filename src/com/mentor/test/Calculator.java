package com.mentor.test;



public class Calculator {

    static int calculator(int a, String operation, int b) {
        int res = 0;

        switch (operation) {
            case "+":
                res = (a + b);
                break;
            case "-":
                res = (a - b);
                break;
            case "*":
                res = (a * b);
                break;
            case "/":
                res = (a / b);
                break;
        }
            return res;

    }
}


