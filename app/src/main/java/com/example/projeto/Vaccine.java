package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

public class Vaccine extends AppCompatActivity {

    AutoCompleteTextView vaccine;
    AutoCompleteTextView agendaDiaVacina;

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

    }

    public void openDialog(){

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                agendaDiaVacina.setText("DATA: " + String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));

            }
        }, 2023, 11, 15);

        dialog.show();
    }
}