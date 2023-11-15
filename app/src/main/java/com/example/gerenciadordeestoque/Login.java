package com.example.gerenciadordeestoque;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Fragment {

    public Login() {
        // Required empty public constructor
    }

    private Boolean authenticate(View v){
        EditText etUser = v.findViewById(R.id.etEmail);
        EditText etPassword = v.findViewById(R.id.etPassword);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("auth", Context.MODE_PRIVATE);
        String user = sharedPreferences.getString("user", "");
        String password = sharedPreferences.getString("password", "");

        return user.equals(etUser.getText().toString()) && password.equals(etPassword.getText().toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button login = view.findViewById(R.id.btnLogin);
        ButtonHelper.setTargetFragment(login, this, new MainMenu(), false);

        return view;
    }
}