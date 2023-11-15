package com.example.gerenciadordeestoque;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class UpdateView extends Fragment {

    public UpdateView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_view, container, false);

        Button btnBack = view.findViewById(R.id.btnBack);
        ButtonHelper.setTargetFragment(btnBack, this, new MainMenu());

        return view;
    }
}