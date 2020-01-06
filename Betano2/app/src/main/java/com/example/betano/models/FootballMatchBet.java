package com.example.betano.models;

import java.util.Random;

public class FootballMatchBet extends Bet {

    private FootballTeam homeTeam = new FootballTeam();
    private FootballTeam awayTeam = new FootballTeam();
    private String date;
    private int BetWin;
    public double homeTeamShare;
    public double awayTeamShare;
    public double drawTeamShare;

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


    public double getHomeTeamShare() {
        return homeTeamShare;
    }

    public void setHomeTeamShare(double homeTeamShare) {
        determineShares(this.homeTeam, this.awayTeam);
        this.homeTeamShare = homeTeamShare;
    }

    public double getAwayTeamShare() {
        determineShares(this.homeTeam, this.awayTeam);
        return awayTeamShare;
    }

    public void setAwayTeamShare(double awayTeamShare) {
        this.awayTeamShare = awayTeamShare;
    }

    private void determineShares(FootballTeam homeTeam, FootballTeam awayTeam) {
        homeTeamShare = 2.43;
        awayTeamShare = 1.67;
        this.drawTeamShare = (this.homeTeamShare + this.awayTeamShare) * 0.85 + 1;
    }

    private int determineWinner() {
        Random winner = new Random();
        int win;
        win = winner.nextInt(2);
        return win;
    }

    public double earning(int betWin) {
        int winner = determineWinner();
        if (winner == betWin && betWin == 0)
            return getInvestmentSum() * homeTeamShare;
        if (winner == betWin && betWin == 1)
            return getInvestmentSum() * drawTeamShare;
        if (winner == betWin && betWin == 2)
            return getInvestmentSum() * drawTeamShare;
        return 0;

    }

    public int getBetWin() {
        return BetWin;
    }

    public void setBetWin(int betWin) {
        BetWin = betWin;
    }
}
