package com.company;

public class Calculator {
    private int principle;
    private float annualInterstRate;
    private int period;
    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public Calculator(int principle, float annualInterstRate, int period) {
        setPrinciple(principle);
        setAnnualInterstRate(annualInterstRate);
        setPeriod(period);
    }

    private void setPrinciple(int principle) {
        this.principle = principle;
    }

    private void setAnnualInterstRate(float annualInterstRate) {
        this.annualInterstRate = annualInterstRate;
    }

    private void setPeriod(int period) {
        this.period = period;
    }

    public double calculateMortgage(){
        float monthlyInterestRate = annualInterstRate/(MONTH_IN_YEAR*PERCENT);
        int numberOfPayments = period*MONTH_IN_YEAR;

        double mortgage = (principle*monthlyInterestRate*Math.pow((1+monthlyInterestRate) , numberOfPayments))/(Math.pow((1+monthlyInterestRate) , numberOfPayments) - 1);
        return mortgage;
    }

    public double calculateRemainingPayment(int numberOfPaymentsDone){
        float monthlyInterestRate = annualInterstRate/(MONTH_IN_YEAR*PERCENT);
        int numberOfPayments = period*MONTH_IN_YEAR;
        double remaininePayment = principle * (Math.pow((1+monthlyInterestRate) , numberOfPayments) - Math.pow((1+monthlyInterestRate) , numberOfPaymentsDone)) / (Math.pow((1+monthlyInterestRate) , numberOfPayments) -1);
        return remaininePayment;
    }
}
