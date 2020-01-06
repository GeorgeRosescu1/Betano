package com.example.betano.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.betano.R;
import com.example.betano.models.FootballLeague;
import com.example.betano.models.FootballMatchBet;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class FragmentAllBets extends Fragment {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    FootballMatchBet betF = new FootballMatchBet();
    FootballLeague footballLeague;
    private List<FootballMatchBet> fmbl = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_bets,container,false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.RV);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));




        return view;
    }

}
