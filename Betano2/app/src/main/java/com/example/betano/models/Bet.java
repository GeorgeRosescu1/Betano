package com.example.betano.models;

public abstract class Bet {

    private double investmentSum;

    public double getInvestmentSum() {
        return investmentSum;
    }

    public void setInvestmentSum(double investmentSum) {
        this.investmentSum = investmentSum;
    }
}
