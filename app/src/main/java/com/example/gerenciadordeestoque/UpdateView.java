package com.example.gerenciadordeestoque;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateView extends Fragment {

    EditText etCodeUpdate, etNameUpdate, etDescriptionUpdate, etQuantityUpdate;

    private void resetForm() {
        etCodeUpdate.setText("");
        etDescriptionUpdate.setText("");
        etNameUpdate.setText("");
        etQuantityUpdate.setText("");
    }

    private boolean validateForm() {
        return !etCodeUpdate.getText().toString().isEmpty() &&
                !etDescriptionUpdate.getText().toString().isEmpty() &&
                !etNameUpdate.getText().toString().isEmpty() &&
                !etQuantityUpdate.getText().toString().isEmpty();
    }

    private void updateProduct() {
        if (validateForm()) {
            Integer codeToUpdate = Integer.valueOf(etCodeUpdate.getText().toString());
            String newName = etNameUpdate.getText().toString();
            String newDescription = etDescriptionUpdate.getText().toString();
            Integer newQuantity = Integer.valueOf(etQuantityUpdate.getText().toString());

            MainActivity mainActivity = (MainActivity) getActivity();

            for (Product product : mainActivity.products) {
                if (product.getCode().equals(codeToUpdate)) {
                    product.setName(newName);
                    product.setDescription(newDescription);
                    product.setQuantity(newQuantity);

                    mainActivity.writeProducts();

                    String toastMessage = "Produto com ID " + codeToUpdate + " alterado com sucesso";
                    Toast.makeText(requireActivity(), toastMessage, Toast.LENGTH_SHORT).show();
                    resetForm();
                    return;
                }
            }
            Toast.makeText(requireActivity(), "Produto não encontrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireActivity(), "Código vazio", Toast.LENGTH_SHORT).show();
        }
    }
    public UpdateView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_view, container, false);

        etCodeUpdate = view.findViewById(R.id.etCodeUpdate);
        etNameUpdate = view.findViewById(R.id.etNameUpdate);
        etDescriptionUpdate = view.findViewById(R.id.etDescriptionUpdate);
        etQuantityUpdate = view.findViewById(R.id.etQuantityUpdate);

        Button btnBack = view.findViewById(R.id.btnBack);
        ButtonHelper.setBackButton(btnBack, this);

        Button btnReset = view.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(v -> resetForm());

        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(v -> updateProduct());

        return view;
    }
}