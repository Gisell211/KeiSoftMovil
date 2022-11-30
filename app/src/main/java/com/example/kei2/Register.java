package com.example.kei2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kei2.Modelo.RegisterRequ;
import com.example.kei2.Retrofit_Data.Api_Client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    EditText name, email, password, password_confirmation;
    Button btnRegistrarse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        password_confirmation = findViewById(R.id.password_confirmation);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(password_confirmation.getText().toString())) {

                    String message = "Es necesarrio que llene todos los campos";
                    Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    RegisterRequ registerRequest = new RegisterRequ();
                    registerRequest.setName(name.getText().toString());
                    registerRequest.setEmail(email.getText().toString());
                    registerRequest.setPassword(password.getText().toString());
                    registerRequest.setPassword_confirmation(password_confirmation.getText().toString());
                    registerUser(registerRequest);
                }
            }
        });
    }
    public void registerUser(RegisterRequ registerRequest) {
        Call<RegisterResponse> registerResponseCall = Api_Client.getService().registerUsers(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if (response.isSuccessful()) {
                    String message = "successfull";
                    Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Register.this, MainActivity2.class));
                    finish();
                } else {
                    String message = "Ocurrio un error intenta de nuevo";
                    Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}