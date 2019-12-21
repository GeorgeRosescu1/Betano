package com.example.betano.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.betano.MainActivity;
import com.example.betano.R;
import com.example.betano.models.FootballLeague;
import com.example.betano.models.FootballTeam;
import com.example.betano.models.Gambler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    DatabaseReference reference;
    FootballLeague footballLeague = FootballLeague.getInstance();
    ArrayList<FootballTeam> top = footballLeague.getTop();
    int index;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final EditText text = view.findViewById(R.id.inText);
        Button saveBtn = view.findViewById(R.id.main_btn);
        FloatingActionButton fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                text.setText(top.get(index).getTeamName() + " " + top.get(index).getPoints());
                index++;
                if (index == top.size())
                    index = 0;
            }
        });

        final Gambler gambler = new Gambler("Popica", 27, "+44070", "jijel",
                "popicajijel99", "gambler", 1243.87);
        Toast.makeText(getContext(), "Firebase connection succes", Toast.LENGTH_LONG).show();
        reference = FirebaseDatabase.getInstance().getReference().child("Gambler");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.push().setValue(gambler);
                Toast.makeText(getActivity(), "Firebase connection succes", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}