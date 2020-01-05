package com.example.betano.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.betano.R;
import com.example.betano.models.Bet;
import com.example.betano.models.FootballLeague;
import com.example.betano.models.FootballMatchBet;
import com.example.betano.models.FootballTeam;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FragmentMyBets extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    FootballMatchBet betF = new FootballMatchBet();
    FootballLeague footballLeague;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_bets, container, false);

        reference = database.getReference().child("FootballMatchBet");
        footballLeague = FootballLeague.getInstance();
        betF.setHomeTeam(footballLeague.getTop().get(1));
        betF.setAwayTeam(footballLeague.getTop().get(2));
        betF.setDate("12.01.2020");
        reference.push().setValue(betF);
        return view;
    }


}
