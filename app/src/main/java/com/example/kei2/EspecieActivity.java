package com.example.kei2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kei2.Modelo.Especie;
import com.example.kei2.Retrofit_Data.Apis;
import com.example.kei2.Retrofit_Data.EspecieService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EspecieActivity extends AppCompatActivity {
    EspecieService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especie);


        TextView ids = (TextView) findViewById(R.id.Id);
        EditText txtId = (EditText) findViewById(R.id.txtId);
        TextView nombres = (TextView) findViewById(R.id.nombres);
        final EditText txtNombres = (EditText) findViewById(R.id.txtNombres);
        TextView razas = (TextView) findViewById(R.id.razas);
        final EditText txtRazas = (EditText) findViewById(R.id.txtRaza);
        TextView edades = (TextView) findViewById(R.id.Edades);
        final EditText txtEdades = (EditText) findViewById(R.id.txtEdades);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        Button btnVolver = (Button) findViewById(R.id.btnVolver);
        Button btnEliminar = (Button) findViewById(R.id.btnEliminar);

        Bundle bundle = getIntent().getExtras();
        final String id = bundle.getString("ID");
        String nom = bundle.getString("NOMBRE");
        String raz = bundle.getString("RAZA");
        String edad = bundle.getString("EDAD");

        txtId.setText(id);
        txtNombres.setText(nom);
        txtRazas.setText(raz);
        txtEdades.setText(edad);
        if (id.trim().length() == 0 || id.equals("")) {
            ids.setVisibility(View.INVISIBLE);
            txtId.setVisibility(View.INVISIBLE);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Especie p = new Especie();
                p.setNombre(txtNombres.getText().toString());
                p.setRaza(txtRazas.getText().toString());
                p.setEdad(txtEdades.getText().toString());
                if (id.equals("")) {
                    addEspecie(p);
                    Intent intent = new Intent(EspecieActivity.this, Adopciones.class);
                    startActivity(intent);
                } else {
                    updateEspecie(p, Integer.valueOf(id));
                    Intent intent = new Intent(EspecieActivity.this, Adopciones.class);
                    startActivity(intent);
                }

            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteEspecie(Integer.valueOf(id));
                Intent intent = new Intent(EspecieActivity.this, Adopciones.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EspecieActivity.this, Adopciones.class);
                startActivity(intent);
            }
        });
    }

    public void addEspecie(Especie p) {
        service = Apis.getEspecieService();
        Call<Especie> call = service.addEspecie(p);
        call.enqueue(new Callback<Especie>() {
            @Override
            public void onResponse(Call<Especie> call, Response<Especie> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EspecieActivity.this, "Se agrego con éxito", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Especie> call, Throwable t) {

                Log.e("Error:", t.getMessage());
            }
        });
    }
    public void updateEspecie(Especie p, int id) {
        service = Apis.getEspecieService();
        Call<Especie> call = service.updateEspecie(p, id);
        call.enqueue(new Callback<Especie>() {
            @Override
            public void onResponse(Call<Especie> call, Response<Especie> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EspecieActivity.this, "Se actualizo con éxito", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Especie> call, Throwable t) {

                Log.e("Error:", t.getMessage());
            }
        });
        Intent intent = new Intent(EspecieActivity.this, Adopciones.class);
        startActivity(intent);
    }
    public void deleteEspecie(int id) {
        service = Apis.getEspecieService();
        Call<Especie> call = service.deleteEspecie(id);
        call.enqueue(new Callback<Especie>() {
            @Override
            public void onResponse(Call<Especie> call, Response<Especie> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(EspecieActivity.this, "Se Elimino el registro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Especie> call, Throwable t) {
                Log.e("Error:", t.getMessage());
            }
        });
        Intent intent = new Intent(EspecieActivity.this, Adopciones.class);
        startActivity(intent);
    }
}

