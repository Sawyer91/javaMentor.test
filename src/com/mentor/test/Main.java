package com.mentor.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.mentor.test.Calculator.calculator;
import static com.mentor.test.Convert.intToRme;
import static com.mentor.test.Convert.romeToInt;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input, operation;
        String str1 = "";
        String str2 = "";
        String [] str;
        int num1 = 0;
        int num2 = 0;

        input = reader.readLine();
        str = input.split(" ");

        operation = str[1];

            if (str[0].matches("[-+]?\\d+") && str[2].matches("[-+]?\\d+") && checkOperator(operation)) {
                num1 = Integer.parseInt(str[0]);
                num2 = Integer.parseInt(str[2]);

                if ((num1 > 0 && num1 <= 10) && (num2 > 0 && num2 <= 10)) {
                    intCalculate(num1, operation, num2);
                } else {
                    throw new IOException("Error");
                }

            } else if (!(str[0].matches("[-+]?\\d+")) && !(str[2].matches("[-+]?\\d+")) && checkOperator(operation)) {
                str1 = str[0];
                str2 = str[2];

                if(check(str1, str2)){
                    romeCalculate(str1, operation, str2);
                }else {
                    throw new IOException("Error");
                }

            } else {
                throw new IOException("Error");
            }


    }

    public static boolean checkOperator(String s){
        if(s.equals("/")){
            return true;
        }else if(s.equals("*")){
            return true;
        }else if(s.equals("+")) {
            return true;
        }else if(s.equals("-")) {
            return true;
        }else {
            return false;
        }
    }


    public static boolean check (String a, String b){

        int num1 = romeToInt(a);
        int num2 = romeToInt(b);

        if((num1 > 0 && num1 <= 10) && (num2 > 0 && num2 <= 10)){
            return true;
        }else {
            return false;
        }
    }

    public static void romeCalculate(String a, String operation, String b){

        int num1 = romeToInt(a);
        int num2 = romeToInt(b);

        System.out.println(intToRme(calculator(num1, operation, num2)));
    }

    public static void intCalculate(int a, String operation, int b){

        System.out.println(calculator(a, operation, b));
    }



}
