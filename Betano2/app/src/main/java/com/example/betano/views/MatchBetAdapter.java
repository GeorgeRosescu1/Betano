package com.example.betano.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.betano.R;
import com.example.betano.models.FootballMatchBet;

import java.util.List;

public class MatchBetAdapter extends RecyclerView.Adapter<MatchBetAdapter.ViewHolder> {

    private List<FootballMatchBet> matches;
    private Context context;
    public MatchBetAdapter(Context context, List<FootballMatchBet> matches){
        this.context = context;
        this.matches = matches;
    }
    @Override
    public MatchBetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_bets_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FootballMatchBet fmb = matches.get(position);
        holder.TitleGame.setText(fmb.getHomeTeam().getTeamName() + " VS "+fmb.getAwayTeam().getTeamName());
        holder.team1.setText(String.valueOf(fmb.homeTeamShare));
        holder.team2.setText(String.valueOf(fmb.awayTeamShare));
        holder.draw.setText(String.valueOf(fmb.drawTeamShare));
        holder.win1.setText("1 Castiga");
        holder.DRAW.setText("X");
        holder.win2.setText("2 Castiga");

    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView TitleGame;
        private TextView win1;
        private TextView win2;
        private TextView DRAW;
        private TextView team1;
        private TextView team2;
        private TextView draw;
        private ViewHolder(View v){
            super(v);
            TitleGame = v.findViewById(R.id.game_name_description);
            win1 = v.findViewById(R.id.win1);
            win2 = v.findViewById(R.id.win2);
            DRAW = v.findViewById(R.id.draw);
            team1 = v.findViewById(R.id.share1);
            team2 = v.findViewById(R.id.share2);
            draw = v.findViewById(R.id.share_x);

        }
    }
}
