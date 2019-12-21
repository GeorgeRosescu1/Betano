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


public class FragmentAllBets extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_bets,container,false);
        return view;
    }

}
