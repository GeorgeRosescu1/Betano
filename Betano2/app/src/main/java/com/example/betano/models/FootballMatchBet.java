package com.example.betano.models;

import java.util.Random;

public class FootballMatchBet extends Bet {

    private FootballTeam homeTeam = new FootballTeam();
    private FootballTeam awayTeam = new FootballTeam();
    private String date;
    private double homeTeamShare;
    private double awayTeamShare;

    public FootballTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(FootballTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FootballTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(FootballTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private void determineShares(FootballTeam homeTeam, FootballTeam awayTeam) {
        this.homeTeamShare = homeTeam.getBudget() / (homeTeam.getStadiumName().length() *
                9.93 * (14 - homeTeam.getChampionshipPosition()) * (homeTeam.getBudget()) / 3);
        this.awayTeamShare = awayTeam.getBudget() / (awayTeam.getStadiumName().length() *
                9.93 * (14 - awayTeam.getChampionshipPosition()) * (awayTeam.getBudget()) / 3) + 2.14;
    }

    private int determineWinner() {

        double homeToWin = 1;
        double awayToWin = 1;
        Random luck = new Random();
        Random matchSituations = new Random();

        double luckyTeam = luck.nextDouble() + 1;
        double matchFactors = (matchSituations.nextDouble() + 2) * 2;

        if (luckyTeam == 1)
            homeToWin = 3;
        else
            awayToWin = 3;

        homeToWin *= matchFactors * this.homeTeamShare;
        awayToWin *= matchFactors * this.awayTeamShare;

        if (homeToWin > awayToWin)
            return 1;
        else
            return 2;
    }

    public double bet(double sum, int team) {
        if (determineWinner() == team && team == 1)
            return sum * this.homeTeamShare;
        if (determineWinner() == team && team == 2)
            return sum * this.awayTeamShare;
        return 0;
    }
}
