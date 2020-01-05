package com.example.betano.models;

public class FootballTeam implements Comparable {

    private String teamName;
    private Double budget;
    private String stadiumName;
    private int championshipPosition;
    private int points;

    public FootballTeam() {
    }

    public FootballTeam(String teamName, Double budget, String stadiumName) {
        this.teamName = teamName;
        this.budget = budget;
        this.stadiumName = stadiumName;
    }

    public FootballTeam(String teamName, Double budget, String stadiumName, int points) {
        this.teamName = teamName;
        this.budget = budget;
        this.stadiumName = stadiumName;
        this.points = points;
    }

    public FootballTeam(String teamName, Double budget, String stadiumName, int championshipPosition, int points) {
        this.teamName = teamName;
        this.budget = budget;
        this.stadiumName = stadiumName;
        this.championshipPosition = championshipPosition;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getChampionshipPosition() {
        return championshipPosition;
    }

    public void setChampionshipPosition(int championshipPosition) {
        this.championshipPosition = championshipPosition;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FootballTeam) {
            FootballTeam footballTeam = (FootballTeam) obj;
            if (footballTeam.getTeamName().equals(this.getTeamName()) &&
                    footballTeam.getBudget() == this.getBudget())
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof FootballTeam) {
            FootballTeam footballTeam = (FootballTeam) o;
            if (footballTeam.getPoints() > this.getPoints())
                return 1;
            if (footballTeam.getPoints() < this.getPoints())
                return -1;
            return 0;
        }
        return 0;
    }
}
