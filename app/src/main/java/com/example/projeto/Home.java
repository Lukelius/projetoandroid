package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button homeProfile;
    Button homeBath;
    Button homeVaccine;
    Button homeAbout;
    Button homeProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeProfile = findViewById(R.id.buttonProfile);
        homeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Home.this,Profile.class);
                startActivity(intent);
            }
        });

        homeBath = findViewById(R.id.buttonBath);
        homeBath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, BathGrooming.class);
                startActivity(intent);
            }
        });

        homeVaccine = findViewById(R.id.buttonVacines);
        homeVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Vaccine.class);
                startActivity(intent);
            }
        });

        homeAbout = findViewById(R.id.buttonAbout);
        homeAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, AboutUs.class);
                startActivity(intent);
            }
        });

        homeProducts = findViewById(R.id.buttonProducts);
        homeProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Products.class);
                startActivity(intent);
            }
        });
    }
}