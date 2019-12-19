package com.example.betano.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HorseRaceBet extends Bet {

    public final static int HORSES_NR = 6;
    public final static ArrayList<Double> HORSES_SHARE = new ArrayList<>(Arrays.asList(4.131, 4.423, 8.611, 9.512, 11.235));

    public int determineHorseWinner() {
        Random random = new Random();
        int horse = random.nextInt(5) + 1;
        return horse;
    }

    public double betHorses(double betSum, int horseNr) {
        if (horseNr == determineHorseWinner())
            return betSum * HORSES_SHARE.get(horseNr - 1);
        return 0;
    }
}
