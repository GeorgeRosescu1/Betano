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
        FootballTeam team1 = new FootballTeam("CFR Cluj", 25121123.43,
                "Dr.Constantin Radulescu", 44);
        FootballTeam team2 = new FootballTeam("FCSB", 31213003.23,
                "Ghencea", 39);
        FootballTeam team3 = new FootballTeam("Astra Giurgiu", 12321123.03,
                "Marin Anastasovici", 43);
        FootballTeam team4 = new FootballTeam("FC Viitorul", 10151003.02,
                "Ovidiu", 35);
        FootballTeam team5 = new FootballTeam("Universitatea Craiova", 9441122.01,
                "Ion Oblemenco", 37);
        FootballTeam team6 = new FootballTeam("Gaz Metan Medias", 7821500.12,
                "Gaz Metan", 36);
        FootballTeam team7 = new FootballTeam("FC Botosani", 8621933.43,
                "Stadionul Municipal Botosani", 33);
        FootballTeam team8 = new FootballTeam("Sepsi OSK Sf. Gheorghe", 9321323.33,
                "Stadionul Municipal", 28);
        FootballTeam team9 = new FootballTeam("FC Dinamo Bucuresti", 15921783.23,
                "Stefan Cel Mare", 28);
        FootballTeam team10 = new FootballTeam("FC Hermannstadt", 10356426.53,
                "Stadionul Municipal Sibiu", 23);
        FootballTeam team11 = new FootballTeam("FC Poli Iasi", 10643875.32,
                "Emil Alexandrescu", 22);
        FootballTeam team12 = new FootballTeam("AFC Chindia Targoviste", 5531245.15,
                "Eugen Popescu", 21);
        FootballTeam team13 = new FootballTeam("FC Academica Clinceni", 4735654.57,
                "Stadionul Clinceni", 20);
        FootballTeam team14 = new FootballTeam("FC Voluntari", 6463731.73,
                "Anghel Iordanescu", 8);

        top.add(team1);
        top.add(team2);
        top.add(team3);
        top.add(team4);
        top.add(team5);
        top.add(team6);
        top.add(team7);
        top.add(team8);
        top.add(team9);
        top.add(team10);
        top.add(team11);
        top.add(team12);
        top.add(team13);
        top.add(team14);
        Collections.sort(top);
        for (FootballTeam footballTeam : top) {
            footballTeam.setChampionshipPosition(top.indexOf(footballTeam));
        }

    }

    public ArrayList<FootballTeam> getTop() {
        return top;
    }

    private FootballLeague() {
    }
}
