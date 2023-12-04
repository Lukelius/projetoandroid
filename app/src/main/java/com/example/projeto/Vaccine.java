package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Vaccine extends AppCompatActivity {

    AutoCompleteTextView vaccine, petVacina, agendaDiaVacina;
    Button agendar;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);

        vaccine = findViewById(R.id.Vacina);
        PopupMenu popupMenuVaccine = new PopupMenu(this, vaccine);

        popupMenuVaccine.getMenuInflater().inflate(R.menu.menu_vaccine, popupMenuVaccine.getMenu());
        popupMenuVaccine.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.type1){
                    vaccine.setText("Vacina tipo 1");
                    vaccine.setHint(null);
                }
                if(id == R.id.type2){
                    vaccine.setText("Vacina tipo 2");
                    vaccine.setHint(null);
                }
                if(id == R.id.type3){
                    vaccine.setText("Vacina tipo 3");
                    vaccine.setHint(null);
                }
                return false;
            }
        });

        vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenuVaccine.show();
            }
        });

        agendaDiaVacina = findViewById(R.id.agendaVacina);

        agendaDiaVacina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();

            }
        });

        petVacina = findViewById(R.id.petChoice);

        agendar = findViewById(R.id.buttonAgendarVacina);
        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String petName = petVacina.getText().toString();
                String vacinaTipo = vaccine.getText().toString();
                String dia = agendaDiaVacina.getText().toString();
                String servico = "Vacinação";
                VaccineData vaccineData = new VaccineData(petName, vacinaTipo, dia, servico);
                reference.child("fifo").child("Services").child(servico).setValue(vaccineData);
                Toast.makeText(Vaccine.this, "Vacinação Agendada com sucesso", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }

    public void openDialog(){

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                agendaDiaVacina.setText("DATA: " + String.valueOf(day) + "/" + String.valueOf(month+1) + "/" + String.valueOf(year));

            }
        }, 2023, 11, 04);

        dialog.show();
    }
}