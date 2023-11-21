package com.example.gerenciadordeestoque;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteView extends Fragment {

    EditText etCodeDelete;

    private void resetForm() {
        etCodeDelete.setText("");
    }

    private boolean validateForm(){
        return !etCodeDelete.getText().toString().isEmpty();
    }

    public DeleteView() {
        // Required empty public constructor
    }

    private void deleteProduct() {
        if (validateForm()) {
            Integer codeToDelete = Integer.valueOf(etCodeDelete.getText().toString());
            MainActivity mainActivity = (MainActivity) getActivity();

            for (Product product : mainActivity.products) {
                if (product.getCode().equals(codeToDelete)) {
                    String productName = product.getName();

                    mainActivity.products.remove(product);
                    mainActivity.writeProducts();

                    String toastMessage = "Produto " + productName + " deletado com sucesso";
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_view, container, false);

        etCodeDelete = view.findViewById(R.id.etCodeDelete);

        Button btnBack = view.findViewById(R.id.btnBack);
        ButtonHelper.setBackButton(btnBack, this);

        Button btnReset = view.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(v -> resetForm());

        Button btnDeleteProduct = view.findViewById(R.id.btnDeleteProduct);
        btnDeleteProduct.setOnClickListener(v -> deleteProduct());

        return view;
    }
}
