package com.company;

import java.text.NumberFormat;

public class Print {
    final static byte MONTH_IN_YEAR = 12;
    public static void printMortgage(int priciple, float annualInterstRate, int period){
        var calculator = new Calculator(priciple, annualInterstRate, period);
        System.out.println(NumberFormat.getCurrencyInstance().format(calculator.calculateMortgage()));
    }
    public static void printShedule(int priciple, float annualInterstRate, int period){
        var calculator = new Calculator(priciple, annualInterstRate, period);
        for (int i = 0; i <=period*MONTH_IN_YEAR; i++) {
            System.out.println(NumberFormat.getCurrencyInstance().format(calculator.calculateRemainingPayment(i)));
        }
    }
}
