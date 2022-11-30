package com.example.kei2.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kei2.Modelo.Products;
import com.example.kei2.R;

import java.util.List;
public class ProductoAdapter
        extends RecyclerView.Adapter<ProductoAdapter.ProductViewHolder>{

    private List<Products> items;
    private LayoutInflater mInflater;
    private Context context;

    @NonNull
    @Override
    public ProductoAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ProductViewHolder holder, int i) {
        holder.imagen.setImageResource(items.get(i).getImagen());
        holder.nombre.setText(items.get(i).getNombre());
        holder.vendido.setText("Mas vendido:"+String.valueOf(items.get(i).getVisitas()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView vendido;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            vendido = (TextView) itemView.findViewById(R.id.visitas);
        }
    }
    public void setItems (List<Products> items) {items = items;}
    public ProductoAdapter(List<Products> items) {  this.items = items;

    }
    }


