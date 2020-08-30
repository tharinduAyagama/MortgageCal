package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        int priciple;
        float annualInterstRate;
        int period;
        float monthlyInterestRate;
        int numberOfPayments;
        double mortgage;

        System.out.print("Principle: ");
        priciple = scanner.nextInt();

        System.out.print ("Annual Interest Rate: ");
        annualInterstRate = scanner.nextFloat();

        System.out.print("Period(Years): ");
        period = scanner.nextInt();

        monthlyInterestRate = annualInterstRate/(MONTH_IN_YEAR*PERCENT);
        numberOfPayments = period*12;

        mortgage = (priciple*monthlyInterestRate*Math.pow((1+monthlyInterestRate) , numberOfPayments))/(Math.pow((1+monthlyInterestRate) , numberOfPayments) - 1);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
