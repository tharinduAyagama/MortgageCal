package com.company;

import java.util.Scanner;

public class Read {
    public static double readNumber(String prompt , double min , double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value<min || value>max)
                System.out.println("Enter a number between " + min + " and " + max);
            else
                break;
        }
        return value;
    }
}
