package com.example.gerenciadordeestoque;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductDetailView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductDetailView extends Fragment {

    TextView tvProductName, tvProductDescription, tvProductCode, tvProductQuantity;
    private Product mProduct;

    public ProductDetailView() {
        // Required empty public constructor
    }

    public ProductDetailView(Product product) {
        this.mProduct = product;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_detail_view, container, false);

        tvProductName = view.findViewById(R.id.tvProductName);
        tvProductName.setText(mProduct.getName());
        tvProductDescription = view.findViewById(R.id.tvProductDescription);
        tvProductDescription.setText(mProduct.getDescription());
        tvProductCode = view.findViewById(R.id.tvProductCode);
        tvProductCode.setText(String.valueOf(mProduct.getCode()));
        tvProductQuantity = view.findViewById(R.id.tvProductQuantity);
        tvProductQuantity.setText(String.valueOf(mProduct.getQuantity()));

        Button btnBack = view.findViewById(R.id.btnDetailBack);
        ButtonHelper.setBackButton(btnBack, this);

        return view;
    }
}