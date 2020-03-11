package com.mentor.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.mentor.test.Calculator.calculator;

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

            if (str[0].matches("[-+]?\\d+") && str[2].matches("[-+]?\\d+")) {
                num1 = Integer.parseInt(str[0]);
                num2 = Integer.parseInt(str[2]);

                if ((num1 > 0 && num1 <= 10) && (num2 > 0 && num2 <= 10)) {
                    calculator(num1, operation, num2);
                } else {
                    throw new IOException();
                }

            } else if (!(str[0].matches("[-+]?\\d+")) && !(str[2].matches("[-+]?\\d+"))) {
                str1 = str[0];
                str2 = str[2];

                if(check(str1, str2)){
                    romeCaclulate(str1, operation, str2);
                }else {
                    throw new IOException();
                }

            } else {
                throw new IOException();
            }


    }


    public static boolean check (String a, String b){
        Convert convert = new Convert();
        int num1 = convert.romeToInt(a);
        int num2 = convert.romeToInt(b);

        if((num1 > 0 && num1 <= 10) && (num2 > 0 && num2 <= 10)){
            return true;
        }else {
            return false;
        }
    }

    public static void romeCaclulate(String a, String operation, String b){
        Convert convert = new Convert();
        int num1 = convert.romeToInt(a);
        int num2 = convert.romeToInt(b);

        calculator(num1, operation, num2);
    }


}
