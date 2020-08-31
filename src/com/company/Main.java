package com.company;

public class Main {
    public static void main(String[] args) {

        int priciple = (int)Read.readNumber("Principle: " , 1000 , 1000000);
        float annualInterstRate = (float)Read.readNumber("Annual Interest Rate: " , 0 , 30);
        int period = (int)Read.readNumber("Period(Years): " , 1,30);

        Print.printMortgage(priciple, annualInterstRate, period);
        Print.printShedule(priciple, annualInterstRate, period);
    }
}
