package com.example.betano.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.betano.R;
import com.example.betano.models.Admin;
import com.example.betano.models.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FragmentProfile extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReferenceUser = database.getReference("User");
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();
    TextView name;
    TextView status;
    TextView email;
    TextView age;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        name = view.findViewById(R.id.final_user_name);
        status = view.findViewById(R.id.user_status);
        email = view.findViewById(R.id.user_mail);
        age = view.findViewById(R.id.user_age);

        email.setText(user.getEmail());
        databaseReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    User user = new User();
                    user.setFirstName(ds.getValue(User.class).getFirstName());
                    user.setLastName(ds.getValue(User.class).getLastName());
                    user.setAge(ds.getValue(User.class).getAge());
                    user.setEmail(ds.getValue(User.class).getEmail());
                    user.setUserType(ds.getValue(User.class).getUserType());

                    name.setText(user.getLastName() + " " + user.getFirstName());
                    status.setText(user.getUserType());
                    age.setText(String.valueOf(user.getAge()));
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
