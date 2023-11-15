package com.example.gerenciadordeestoque;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateView extends Fragment {

    EditText etCode, etName, etDescription, etQuantity;

    private void resetForm(){
        etCode.setText("");
        etDescription.setText("");
        etName.setText("");
        etQuantity.setText("");
    }

    private boolean validateForm(){
        return !etCode.getText().toString().isEmpty() &&
                !etDescription.getText().toString().isEmpty() &&
                !etName.getText().toString().isEmpty() &&
                !etQuantity.getText().toString().isEmpty();
    }

    private void createProduct(){
        if (validateForm()) {
            String code = etCode.getText().toString();
            String description = etDescription.getText().toString();
            String name = etName.getText().toString();
            Integer quantity = Integer.valueOf(etQuantity.getText().toString());

            resetForm();

            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.products.add(new Product(code, description, name, quantity));
            mainActivity.writeProducts();

            Toast.makeText(requireActivity(), getText(R.string.success_feedback), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireActivity(), getText(R.string.invalid_form_feedback), Toast.LENGTH_SHORT).show();
        }
    }

    public CreateView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_view, container, false);

        etCode = view.findViewById(R.id.etCode);
        etName = view.findViewById(R.id.etName);
        etDescription = view.findViewById(R.id.etDescription);
        etQuantity = view.findViewById(R.id.etQuantity);

        Button btnBack = view.findViewById(R.id.btnBack);
        ButtonHelper.setBackButton(btnBack, this);

        Button btnReset = view.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(v -> resetForm());

        Button btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> createProduct());

        return view;
    }
}