package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BathGrooming extends AppCompatActivity {
    AutoCompleteTextView services, agendaBanho, escolhaPet;
    Button agendarButton;
    FirebaseDatabase database;
    DatabaseReference reference;
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

        escolhaPet = findViewById(R.id.petChoice);

        agendarButton = findViewById(R.id.agendarBanho);
        agendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String petName = escolhaPet.getText().toString();
                String serviceType = services.getText().toString();
                String dia = agendaBanho.getText().toString();
                String servico = "Banho";
                BathData bathData = new BathData(petName, serviceType, dia, servico);
                reference.child("fifo").child("Services").child(servico).setValue(bathData);
                Toast.makeText(BathGrooming.this, "Banho agendado com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        });





    }

    public void openDialog(){

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                agendaBanho.setText("DATA: " + String.valueOf(day) + "/" + String.valueOf(month+1) + "/" + String.valueOf(year));

            }
        }, 2023, 11, 04);

        dialog.show();
    }

}