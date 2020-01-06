package com.example.betano.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.betano.MainActivity;
import com.example.betano.R;
import com.example.betano.models.Admin;
import com.example.betano.models.FootballLeague;
import com.example.betano.models.FootballTeam;
import com.example.betano.models.Gambler;
import com.example.betano.models.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FragmentHome extends Fragment {

    FootballLeague footballLeague = FootballLeague.getInstance();
    ArrayList<FootballTeam> top = footballLeague.getTop();
    int index;
    TextView text;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FloatingActionButton fab;
    FirebaseUser firebaseUser = auth.getCurrentUser();
    DatabaseReference databaseReferenceUser = database.getReference("User");
    String emailCurrentUser;
    String typeCurrentUser;

    @SuppressLint("RestrictedApi")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        text = view.findViewById(R.id.inText);
        fab = view.findViewById(R.id.fab_create_bet);
        emailCurrentUser = firebaseUser.getEmail();

        databaseReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    User user = new User();
                    if (emailCurrentUser.equals(ds.getValue(User.class).getEmail())) {
                        typeCurrentUser = ds.getValue(User.class).getUserType();
                        Toast.makeText(getActivity(),"Preparing the data...",Toast.LENGTH_SHORT).show();
                        text.setText("User is " + typeCurrentUser);

                        if (typeCurrentUser.equals("Admin")) {
                            fab.setVisibility(View.VISIBLE);
                            fab.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(getActivity().getBaseContext(), CreateBet.class));

                                }
                            });
                        }

                    }

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
