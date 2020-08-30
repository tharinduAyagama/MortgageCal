package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int priciple = (int)readNumber("Principle: " , 1000 , 1000000);
        float annualInterstRate = (float)readNumber("Annual Interest Rate: " , 0 , 30);
        int period = (int)readNumber("Period(Years): " , 1,30);

        double mortgage = calculateMortgage(priciple,annualInterstRate,period);
        System.out.println("--MORTGAGE--");
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
        System.out.println();

        System.out.println("--REMAINING PAYMENT SHEDULE--");
        for (int i = 0; i <= period*MONTH_IN_YEAR; i++) {
            System.out.println("The remaining payment after paying " + i +" time is " + calculateRemainingPayment(priciple,annualInterstRate,period,i));

        }
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
    public static double calculateRemainingPayment(int priciple , float annualInterstRate , int period ,int numberOfPaymentsDone){
        float monthlyInterestRate = annualInterstRate/(MONTH_IN_YEAR*PERCENT);
        int numberOfPayments = period*12;
            double remaininePayment = priciple * (Math.pow((1+monthlyInterestRate) , numberOfPayments) - Math.pow((1+monthlyInterestRate) , numberOfPaymentsDone)) / (Math.pow((1+monthlyInterestRate) , numberOfPayments) -1);
            return remaininePayment;
    }

    public static double calculateMortgage(int priciple , float annualInterstRate , int period){
        float monthlyInterestRate = annualInterstRate/(MONTH_IN_YEAR*PERCENT);
        int numberOfPayments = period*12;

        double mortgage = (priciple*monthlyInterestRate*Math.pow((1+monthlyInterestRate) , numberOfPayments))/(Math.pow((1+monthlyInterestRate) , numberOfPayments) - 1);
        return mortgage;
    }
}
