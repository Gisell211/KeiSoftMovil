package com.example.kei2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
    }
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
    public void Productos(View view){
        Intent intent = new Intent(MainActivity2.this, Productos.class);
        startActivity(intent);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_tienda:
                Intent intent1 = new Intent(MainActivity2.this, Productos.class);
                startActivity(intent1);
                break;
            case R.id.nav_fundacion:
                Intent intent2 = new Intent(MainActivity2.this, Fundaciones.class);
                startActivity(intent2);
                break;
            case R.id.nav_adoptar:
                Intent intent = new Intent(MainActivity2.this, Adopciones.class);
                startActivity(intent);
                break;
            case R.id.nav_donar:
                Intent intent3 = new Intent(MainActivity2.this, Donaciones.class);
                startActivity(intent3);
                break;
            case R.id.nav_mapa:
                Intent intent6 = new Intent(MainActivity2.this, Mapa.class);
                startActivity(intent6);
                break;
            case R.id.nav_perfil:
                Intent intent7 = new Intent(MainActivity2.this, Perfil.class);
                startActivity(intent7);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}