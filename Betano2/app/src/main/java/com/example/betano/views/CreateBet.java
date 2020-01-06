package com.example.betano.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.betano.MainActivity;
import com.example.betano.R;
import com.example.betano.models.FootballLeague;
import com.example.betano.models.FootballMatchBet;
import com.example.betano.models.FootballTeam;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CreateBet extends AppCompatActivity {

    TextView homeTeamText, awayTeamText, matchDayText;
    Button createBetBtn;
    ProgressBar progressBarCreateBet;
    FootballTeam homeTeam;
    FootballTeam awayTeam;
    String date;
    FootballLeague footballLeague;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    int index;
    String homeTeamName;
    String awayTeamName;
    public static ArrayList<FootballTeam> top = new ArrayList<>();
    FootballMatchBet footballMatchBet;
    DatabaseReference databaseReferenceFootballMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        homeTeamText = findViewById(R.id.home_team_text);
        awayTeamText = findViewById(R.id.away_team_text);
        matchDayText = findViewById(R.id.date_match_text);
        createBetBtn = findViewById(R.id.create_bet_btn);
        progressBarCreateBet = findViewById(R.id.progress_bar_create_bet);

        footballLeague = FootballLeague.getInstance();
        top = footballLeague.getTop();
        databaseReferenceFootballMatch = database.getReference().child("FootballMatchBet");

        createBetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarCreateBet.setVisibility(View.VISIBLE);
                homeTeamName = homeTeamText.getText().toString();
                awayTeamName = awayTeamText.getText().toString();
                date = matchDayText.getText().toString();

                for (FootballTeam footballTeam : top) {
                    if (footballTeam.getTeamName().equals(homeTeamName))
                        homeTeam = footballTeam;
                    else if (footballTeam.getTeamName().equals(awayTeamName))
                        awayTeam = footballTeam;
                }

                footballMatchBet = new FootballMatchBet();
                footballMatchBet.setHomeTeam(homeTeam);
                footballMatchBet.setAwayTeam(awayTeam);
                footballMatchBet.setDate(date);
                databaseReferenceFootballMatch.push().setValue(footballMatchBet);

                progressBarCreateBet.setVisibility(View.GONE);
                startActivity(new Intent(CreateBet.this, MainActivity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(CreateBet.this, MainActivity.class));
        finish();
        return true;
    }
}
