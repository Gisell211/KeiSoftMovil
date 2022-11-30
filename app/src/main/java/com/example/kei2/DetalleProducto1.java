package com.example.kei2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetalleProducto1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto1);
    }

    public void Detalle(View view){
        Intent intent = new Intent(DetalleProducto1.this, DetalleProducto2.class);
        startActivity(intent);
    }
}