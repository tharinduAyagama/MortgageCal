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

        while (true){
            System.out.print("Principle: ");
            priciple = scanner.nextInt();
            if(priciple<1000 || priciple>1000000){
                System.out.println("Enter a number between 1000 and 1000000");
            }
            else {
                break;
            }
        }

        while (true){
            System.out.print ("Annual Interest Rate: ");
            annualInterstRate = scanner.nextFloat();
            if(annualInterstRate<=0 || annualInterstRate>=30){
                System.out.println("Enter a number between 0 and 30");
            }
            else {
                break;
            }
        }

        while (true){
            System.out.print("Period(Years): ");
            period = scanner.nextInt();
            if(annualInterstRate<=0 || annualInterstRate>30){
                System.out.println("Enter a number between 1 and 30");
            }
            else {
                break;
            }
        }

        monthlyInterestRate = annualInterstRate/(MONTH_IN_YEAR*PERCENT);
        numberOfPayments = period*12;

        mortgage = (priciple*monthlyInterestRate*Math.pow((1+monthlyInterestRate) , numberOfPayments))/(Math.pow((1+monthlyInterestRate) , numberOfPayments) - 1);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
