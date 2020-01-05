package com.example.betano.models;

public class Bet {

    private double investmentSum;
    private int type; //1-match 2-cai

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getInvestmentSum() {
        return investmentSum;
    }

    public void setInvestmentSum(double investmentSum) {
        this.investmentSum = investmentSum;
    }
}
