package com.example.gerenciadordeestoque;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class ProductsListView extends Fragment {

    public ProductsListView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_list_view, container, false);

        Button btnBack = view.findViewById(R.id.btnBack);
        ButtonHelper.setBackButton(btnBack, this);

        ListView listView = view.findViewById(R.id.viewProducts);
        ProductAdapter adapter = new ProductAdapter(requireContext(),((MainActivity) requireActivity()).products);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Product product = ((MainActivity) requireActivity()).products.get(position);
                fragmentTransaction.replace(R.id.fcContent, new ProductDetailView(product));

                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });

        return view;
    }
}