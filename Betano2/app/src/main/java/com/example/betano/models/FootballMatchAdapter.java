package com.example.betano.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.betano.R;

import java.util.ArrayList;

public class FootballMatchAdapter extends RecyclerView.Adapter<FootballMatchAdapter.FootballMatchViewHolder> {

    private Context context;
    private ArrayList<FootballMatchBet> footballMatchBets;

    public FootballMatchAdapter(Context context, ArrayList<FootballMatchBet> footballMatchBets) {
        this.context = context;
        this.footballMatchBets = footballMatchBets;
    }

    @NonNull
    @Override
    public FootballMatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.bet_card, null);
        return new FootballMatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballMatchViewHolder holder, int position) {
        FootballMatchBet footballMatchBet = footballMatchBets.get(position);

        holder.matchTitle.setText(footballMatchBet.getHomeTeam().getTeamName() + " vs " + footballMatchBet.getAwayTeam().getTeamName());
        holder.matchDate.setText(footballMatchBet.getDate());
        holder.textShare1.setText(String.valueOf(footballMatchBet.getHomeTeamShare()));
        holder.textShare2.setText(String.valueOf(footballMatchBet.getAwayTeamShare()));
        holder.textShareX.setText(String.valueOf(footballMatchBet.getAwayTeamShare() - footballMatchBet.getHomeTeamShare() + 1));
    }

    @Override
    public int getItemCount() {
        return footballMatchBets.size();
    }

    class FootballMatchViewHolder extends RecyclerView.ViewHolder {
        TextView matchTitle, matchDate, textX, text1, text2, textShare1, textShare2, textShareX;


        public FootballMatchViewHolder(@NonNull View itemView) {
            super(itemView);

            matchTitle = itemView.findViewById(R.id.card_teams_text);
            matchDate = itemView.findViewById(R.id.card_date_text);
            text1 = itemView.findViewById(R.id.card_1_text);
            text2 = itemView.findViewById(R.id.card_2_text);
            textX = itemView.findViewById(R.id.card_x_text);
            textShare1 = itemView.findViewById(R.id.card_1_share_text);
            textShare2 = itemView.findViewById(R.id.card_2_share_text);
            textShareX = itemView.findViewById(R.id.card_x_share_text);

        }
    }

}
