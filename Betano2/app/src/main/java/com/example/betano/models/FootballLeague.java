package com.example.betano.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class FootballLeague {

    private static final FootballLeague ourInstance = new FootballLeague();
    public static ArrayList<FootballTeam> top = new ArrayList<>();


    public static FootballLeague getInstance() {
        populateTop();
        return ourInstance;
    }

    private static void populateTop() {
        FootballTeam team1 = new FootballTeam("CFR Cluj", 25 / 021 / 123.43,
                "Dr.Constantin Radulescu", 41);
        FootballTeam team2 = new FootballTeam("FCSB", 31 / 213 / 003.23,
                "Ghencea", 36);
        FootballTeam team3 = new FootballTeam("Astra", 12 / 001 / 123.03,
                "Marin Anastasovici", 40);
        FootballTeam team4 = new FootballTeam("FC Viitorul", 10 / 151 / 003.02,
                "Ovidiu", 35);

        top.add(team1);
        top.add(team2);
        top.add(team3);
        top.add(team4);
        Collections.sort(top);


    }
    public ArrayList<FootballTeam> getTop(){
        return top;
    }
    private FootballLeague() {
    }
}
