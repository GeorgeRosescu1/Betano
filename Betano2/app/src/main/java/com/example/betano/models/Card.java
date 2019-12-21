package com.example.betano.models;

public class Card {
    private String userName;
    private long nr;
    private int cvv; //this will be the pass for the card
    private int year;
    private int month;

    public Card() {
    }

    public Card(String userName, long nr, int year, int month) {
        this.userName = userName;
        this.nr = nr;
        this.year = year;
        this.month = month;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getNr() {
        return nr;
    }

    public void setNr(long nr) {
        this.nr = nr;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
