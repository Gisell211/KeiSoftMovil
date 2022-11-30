package com.example.kei2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.kei2.Modelo.Especie;
import com.example.kei2.Retrofit_Data.Apis;
import com.example.kei2.Retrofit_Data.EspecieService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Adopciones extends AppCompatActivity {

    EspecieService especieService;
    List<Especie> listEspecie = new ArrayList<>();
    ListView listView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopciones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.listView);

        listEspecie();

        FloatingActionButton fab = findViewById(R.id.fabe);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Adopciones.this, EspecieActivity.class);
                intent.putExtra("ID","");
                intent.putExtra("NOMBRE","");
                intent.putExtra("RAZA","");
                intent.putExtra("EDAD","");

                startActivity(intent);
            }
        });
    }
    public void listEspecie() {
        especieService = Apis.getEspecieService();
        Call<List<Especie>> call = especieService.getEspecie();
        call.enqueue(new Callback<List<Especie>>() {
            @Override
            public void onResponse(Call<List<Especie>> call, Response<List<Especie>> response) {
                if (response.isSuccessful()) {
                    listEspecie = response.body();
                    listView.setAdapter(new EspecieAdapter(Adopciones.this, R.layout.content_main,listEspecie));
                }
            }

            @Override
            public void onFailure(Call<List<Especie>> call, Throwable t) {
                Log.e("Error:", t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //      || super.onSupportNavigateUp();
}