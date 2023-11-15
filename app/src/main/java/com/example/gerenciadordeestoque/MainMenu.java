package com.example.gerenciadordeestoque;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainMenu extends Fragment {

    public MainMenu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        Button btnCreate = view.findViewById(R.id.btnCreate);
        ButtonHelper.setTargetFragment(btnCreate, this, new CreateView());
        Button btnList = view.findViewById(R.id.btnList);
        ButtonHelper.setTargetFragment(btnList, this, new ListView());
        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        ButtonHelper.setTargetFragment(btnUpdate, this, new UpdateView());
        Button btnDelete = view.findViewById(R.id.btnDelete);
        ButtonHelper.setTargetFragment(btnDelete, this, new DeleteView());

        return view;
    }
}