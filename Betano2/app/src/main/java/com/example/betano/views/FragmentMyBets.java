package com.example.betano.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.betano.MainActivity;
import com.example.betano.R;
import com.example.betano.models.Bet;
import com.example.betano.models.FootballLeague;
import com.example.betano.models.FootballMatchAdapter;
import com.example.betano.models.FootballMatchBet;
import com.example.betano.models.FootballTeam;
import com.example.betano.models.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class FragmentMyBets extends Fragment {

    RecyclerView recyclerView;
    FootballMatchAdapter footballMatchAdapter;
    ArrayList<FootballMatchBet> footballMatchBetList;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReferenceFootballBet = database.getReference("FootballMatchBet");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_bets, container, false);

        footballMatchBetList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycle_view_my_bets);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        databaseReferenceFootballBet.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    FootballMatchBet footballMatchBet = new FootballMatchBet();
                    FootballTeam footballTeamHome = new FootballTeam();
                    FootballTeam footballTeamAway = new FootballTeam();
                    String homeTeamName, homeTeamStadium;
                    String awayTeamName, awayTeamStadium;
                    Double homeTeamBudget, awayTeamBudget;
                    int awayTeamPoints, awayTeamChampionShipPosition, homeTeamPoints, homeTeamChampionShipPosition;
                    String date;

                    awayTeamName = ds.getValue(FootballMatchBet.class).getAwayTeam().getTeamName();
                    awayTeamBudget = ds.getValue(FootballMatchBet.class).getAwayTeam().getBudget();
                    awayTeamStadium = ds.getValue(FootballMatchBet.class).getAwayTeam().getStadiumName();
                    awayTeamChampionShipPosition = ds.getValue(FootballMatchBet.class).getAwayTeam().getChampionshipPosition();
                    awayTeamPoints = ds.getValue(FootballMatchBet.class).getAwayTeam().getPoints();

                    date = ds.getValue(FootballMatchBet.class).getDate();

                    homeTeamName = ds.getValue(FootballMatchBet.class).getHomeTeam().getTeamName();
                    homeTeamBudget = ds.getValue(FootballMatchBet.class).getHomeTeam().getBudget();
                    homeTeamStadium = ds.getValue(FootballMatchBet.class).getHomeTeam().getStadiumName();
                    homeTeamChampionShipPosition = ds.getValue(FootballMatchBet.class).getHomeTeam().getChampionshipPosition();
                    homeTeamPoints = ds.getValue(FootballMatchBet.class).getHomeTeam().getPoints();

                    footballTeamHome.setTeamName(homeTeamName);
                    footballTeamHome.setStadiumName(homeTeamStadium);
                    footballTeamHome.setBudget(homeTeamBudget);
                    footballTeamHome.setPoints(homeTeamPoints);
                    footballTeamHome.setChampionshipPosition(homeTeamChampionShipPosition);

                    footballTeamAway.setTeamName(awayTeamName);
                    footballTeamAway.setStadiumName(awayTeamStadium);
                    footballTeamAway.setBudget(awayTeamBudget);
                    footballTeamAway.setPoints(awayTeamPoints);
                    footballTeamAway.setChampionshipPosition(awayTeamChampionShipPosition);

                    footballMatchBet.setHomeTeam(footballTeamHome);
                    footballMatchBet.setAwayTeam(footballTeamAway);
                    footballMatchBet.setDate(date);
                    footballMatchBet.setAwayTeamShare(footballMatchBet.getAwayTeamShare());
                    footballMatchBet.setHomeTeamShare(footballMatchBet.getHomeTeamShare());
                    footballMatchBetList.add(footballMatchBet);

                    footballMatchAdapter = new FootballMatchAdapter(FragmentMyBets.this.getContext(), footballMatchBetList);
                    recyclerView.setAdapter(footballMatchAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });


        return view;
    }


}
