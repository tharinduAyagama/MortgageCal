package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int priciple = (int)readNumber("Principle: " , 1000 , 1000000);
        float annualInterstRate = (float)readNumber("Annual Interest Rate: " , 0 , 30);
        int period = (int)readNumber("Period(Years): " , 1,30);

        double mortgage = calculateMortgage(priciple,annualInterstRate,period);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

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

    public static double calculateMortgage(int priciple , float annualInterstRate , int period){
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterstRate/(MONTH_IN_YEAR*PERCENT);
        int numberOfPayments = period*12;

        double mortgage = (priciple*monthlyInterestRate*Math.pow((1+monthlyInterestRate) , numberOfPayments))/(Math.pow((1+monthlyInterestRate) , numberOfPayments) - 1);
        return mortgage;
    }
}
