package com.example.betano.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Gambler extends User {


    private double budget;
    private Set<Bet> myBets = new HashSet<>();

    public Gambler(){

    }
    public Gambler(double budget) {
        this.budget = budget;
    }

    public Gambler(String firstName, int age, String lastName, String username, String userType, double budget) {
        super(firstName, age, lastName, username, userType);
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }
}
