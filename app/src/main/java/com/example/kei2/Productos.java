package com.example.kei2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kei2.Adaptador.ProductoAdapter;
import com.example.kei2.Modelo.Products;

import java.util.ArrayList;
import java.util.List;

public class Productos extends AppCompatActivity {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        List items = new ArrayList();
        items.add(new Products(R.drawable.alimentos, "Alimento gato", 20));
        items.add(new Products(R.drawable.collar2, "Collar para perros", 46));
        items.add(new Products(R.drawable.alimentos, "Alimento", 32));
        items.add(new Products(R.drawable.balon, "Baloncito",42));
        items.add(new Products(R.drawable.alimentos, "Alimento gato grande",70));
        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador1);
        recycler.setHasFixedSize(true);
        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
        // Crear un nuevo adaptador
        adapter = new ProductoAdapter(items);
        recycler.setAdapter(adapter);
    }
}