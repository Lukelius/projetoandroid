package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.PopupMenu;

public class BathGrooming extends AppCompatActivity {
    AutoCompleteTextView services;
    AutoCompleteTextView agendaBanho;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bath_grooming);

        services = findViewById(R.id.serviceType);
        PopupMenu popupMenuServices = new PopupMenu(this, services);

        popupMenuServices.getMenuInflater().inflate(R.menu.menu_bathgrooming, popupMenuServices.getMenu());
        popupMenuServices.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.bath){
                    services.setText("Banho");
                    services.setHint(null);
                }
                if(id == R.id.grooming){
                    services.setText("Banho e Tosa");
                    services.setHint(null);
                }
                return false;
            }
        });

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenuServices.show();
            }
        });

        agendaBanho = findViewById(R.id.agendaBanhoTosa);
        agendaBanho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });





    }

    public void openDialog(){

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                agendaBanho.setText("DATA: " + String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));

            }
        }, 2023, 11, 15);

        dialog.show();
    }

}