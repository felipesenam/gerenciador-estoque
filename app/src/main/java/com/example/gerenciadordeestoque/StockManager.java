package com.example.gerenciadordeestoque;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class StockManager extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences sharedPreferences = getSharedPreferences("auth", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user", "admin");
        editor.putString("password", "admin");

        editor.apply();
    }
}
