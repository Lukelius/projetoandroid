package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile extends AppCompatActivity {

    //Button petRegister;

    Button pets, agendamentos;
    TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        agendamentos = findViewById(R.id.button_agendamentos);


        agendamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Agendamentos.class);
                startActivity(intent);
            }
        });


        FloatingActionButton petRegister = findViewById(R.id.buttonToRegister);
        petRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Profile.this, PetRegister.class);
                startActivity(intent);
            }
        });

        pets = findViewById(R.id.pets);


        user = findViewById(R.id.userName);

    }



}