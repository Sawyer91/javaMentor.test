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


        while (true) {

            input = reader.readLine();
            str = input.split(" ");

            operation = str[1];
            str1 = str[0];
            str2 = str[2];

            if (!checkIn(input) && checkOperator(operation)) {
                
                if (str1.matches("[-+]?\\d+") && str2.matches("[-+]?\\d+")) {
                    num1 = Integer.parseInt(str1);
                    num2 = Integer.parseInt(str2);

                    if ((num1 > 0 && num1 <= 10) && (num2 > 0 && num2 <= 10)) {
                        intCalculate(num1, operation, num2);
                    } else {
                        throw new IOException("Error");
                    }

                } else if (!(str1.matches("[-+]?\\d+")) && !(str2.matches("[-+]?\\d+")) && checkNumRom(str1, str2)) {

                        romeCalculate(str1, operation, str2);

                } else {
                    throw new IOException("Error");
                }
            }else {
                throw new IllegalArgumentException(" Incorrect input");
            }
        }

    }

    //проверка длины входящих данных
    public static boolean checkIn(String s){
        String[] str = s.split(" ");
        if(str.length > 4){
            return true;
        }else {
            return false;
        }
    }

    //проверка операции
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

    //проверка входящих чисел для Римских символов
    public static boolean checkNumRom (String a, String b){

        int num1 = romeToInt(a);
        int num2 = romeToInt(b);

        if((num1 > 0 && num1 <= 10) && (num2 > 0 && num2 <= 10)){
            return true;
        }else {
            return false;
        }
    }

    //вызов калькулятора для Римских символов
    public static void romeCalculate(String a, String operation, String b){

        int num1 = romeToInt(a);
        int num2 = romeToInt(b);

        System.out.println(intToRme(calculator(num1, operation, num2)));
    }

    //вызов калкулятора для int
    public static void intCalculate(int a, String operation, int b){

        System.out.println(calculator(a, operation, b));
    }


}
