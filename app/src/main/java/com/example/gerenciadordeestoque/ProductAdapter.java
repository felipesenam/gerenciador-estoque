package com.example.gerenciadordeestoque;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> produtos) {
        super(context, 0, produtos);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.product_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = getItem(position);

        if (product != null) {
            holder.textViewNome.setText(product.getName());
            holder.textViewCodigo.setText("Código: " + product.getCode());
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView textViewNome;
        TextView textViewCodigo;

        ViewHolder(View view) {
            textViewNome = view.findViewById(R.id.etListName);
            textViewCodigo = view.findViewById(R.id.etListCode);
        }
    }
}

