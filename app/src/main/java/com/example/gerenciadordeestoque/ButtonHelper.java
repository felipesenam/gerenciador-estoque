package com.example.gerenciadordeestoque;

import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ButtonHelper {
    public static void setTargetFragment(Button button, final Fragment fragment, final Fragment target){
        setTargetFragment(button, fragment, target, true);
    }

    public static void setTargetFragment(Button button, final Fragment fragment, final Fragment target, boolean addToBackStack) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = fragment.requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fcContent, target);
                if (addToBackStack) {
                    fragmentTransaction.addToBackStack(null);
                }

                fragmentTransaction.commit();
            }
        });
    }
    public static void setBackButton(Button button, Fragment fragment){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.requireActivity()
                        .getOnBackPressedDispatcher()
                        .onBackPressed();
            }
        });
    }
}
