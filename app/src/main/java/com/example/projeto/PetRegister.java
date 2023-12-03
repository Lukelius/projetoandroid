package com.example.projeto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.projeto.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PetRegister extends AppCompatActivity {

    ActivityMainBinding binding;
    Button petRegProfile, registroPet;
    TextInputEditText nome;
    AutoCompleteTextView tipos, dataNascimento, portes;
    FirebaseDatabase database;
    DatabaseReference reference;
    private ArrayList<PetData> pets = new ArrayList<PetData>();


    int petId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_register);

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

        dataNascimento = findViewById(R.id.dtNasc);
        dataNascimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();

            }
        });

        nome = findViewById(R.id.nomePet);



        petRegProfile = findViewById(R.id.voltarBottao);
        petRegProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        registroPet = findViewById(R.id.cadastrarPet);
        registroPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                execute();
            }
        });





    }


    public void execute(){

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");
        String petName = nome.getText().toString();
        String petType = tipos.getText().toString();
        String petPort = portes.getText().toString();
        String petAge = dataNascimento.getText().toString();
        PetData petData = new PetData(gerarPetId(), petName, petType, petPort, petAge);
        pets.add(petData);

        reference.child("fifo").child("Pets").child(petName).setValue(petData).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                nome.setText(petName);
                tipos.setText(petType);
                portes.setText(petPort);
                dataNascimento.setText(petAge);
                Intent intent = new Intent(PetRegister.this, PetProfile.class);
                Toast.makeText(PetRegister.this, "Pet cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }



    public int gerarPetId() {
        return ++petId;
    }

    public void openDialog(){

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                dataNascimento.setText("DATA: " + String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));

            }
        }, 2023, 11, 15);

        dialog.show();
    }
}