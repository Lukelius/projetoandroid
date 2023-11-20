package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupMenu;

import com.google.android.material.textfield.TextInputLayout;

public class PetRegister extends AppCompatActivity {

    Button petRegProfile;

    AutoCompleteTextView portes;
    AutoCompleteTextView tipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_register);

        petRegProfile = findViewById(R.id.voltarBottao);
        petRegProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tipos = findViewById(R.id.tipoPet);
        PopupMenu popupMenuTipo = new PopupMenu(
                this, tipos
        );

        popupMenuTipo.getMenuInflater().inflate(R.menu.menu_tipos, popupMenuTipo.getMenu());
        popupMenuTipo.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.tipoCao){
                    tipos.setText("Cachorro");
                    tipos.setHint(null);
                }
                if (id == R.id.tipoGato){
                    tipos.setText("Gato");
                    tipos.setHint(null);
                }
                return false;
            }
        });

        portes = findViewById(R.id.portes);
        PopupMenu popupMenu = new PopupMenu(
                this, portes
        );

        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id==R.id.portePequeno){
                    portes.setText("Porte Pequeno");
                    portes.setHint(null);

                }
                if(id== R.id.porteMedio){
                    portes.setText("Porte Medio");
                    portes.setHint(null);

                }
                if (id == R.id.porteGrande){
                    portes.setText("Porte Grande");
                    portes.setHint(null);

                }

                return false;
            }
        });


        tipos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenuTipo.show();
            }
        });

        portes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu.show();

            }
        });




    }
}