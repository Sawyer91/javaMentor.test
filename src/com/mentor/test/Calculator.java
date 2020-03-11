package com.mentor.test;



public class Calculator{

    public static void calculator(int a, String operation, int b){
        if(operation.equals("+")){
            System.out.println(a + b);
        }else if(operation.equals("-")){
            System.out.println(a - b);
        }else if(operation.equals("*")){
            System.out.println(a * b);
        }else if(operation.equals("/")){
            System.out.println(a / b);
        }else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
