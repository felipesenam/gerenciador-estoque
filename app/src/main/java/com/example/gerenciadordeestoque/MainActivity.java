package com.example.gerenciadordeestoque;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Product> products;

    public void readProducts() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStreamReader stream = new InputStreamReader(openFileInput("db.json"));
            BufferedReader reader = new BufferedReader(stream);
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            Toast.makeText(MainActivity.this, content.toString(), Toast.LENGTH_SHORT).show();
            products = mapper.readValue(content.toString(), new TypeReference<List<Product>>() {});

        } catch (FileNotFoundException e) {
            try {
                products = new ArrayList<>();
                OutputStreamWriter ostream = new OutputStreamWriter(openFileOutput("db.json", Activity.MODE_PRIVATE));
                mapper.writeValue(ostream, products);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeProducts() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            OutputStreamWriter stream = new OutputStreamWriter(openFileOutput("db.json", Activity.MODE_PRIVATE));
            mapper.writeValue(stream, products);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fcContent, new Login())
                    .commit();
        }

        readProducts();

        // Disable night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        writeProducts();
    }
}