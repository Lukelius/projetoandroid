package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class form_login extends AppCompatActivity {

    private TextView text_tela_cadastro;

    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(form_login.this,form_cadastro.class);
                startActivity(intent);
            }
        });

        //Botão
        home = findViewById(R.id.button_entrar);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(form_login.this,Home.class);
                startActivity(intent);


            }
        });







    }

   private void IniciarComponentes(){
        text_tela_cadastro = findViewById(R.id.cadastrar);

   }
}