package com.example.projeto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class form_cadastro extends AppCompatActivity {

    EditText nomeReg, userName, emailReg, senhaReg;
    Button buttonReg;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        nomeReg = findViewById(R.id.nome);
        userName = findViewById(R.id.usernameReg);
        emailReg = findViewById(R.id.email2);
        senhaReg = findViewById(R.id.senha2);
        buttonReg = findViewById(R.id.button_cadastrar);

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String name = nomeReg.getText().toString();
                String email = emailReg.getText().toString();
                String username = userName.getText().toString();
                String password = senhaReg.getText().toString();
                HelperClass helperClass = new HelperClass(name, email, username, password);
                reference.child(username).setValue(helperClass);
                Toast.makeText(form_cadastro.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(form_cadastro.this, form_login.class);
                startActivity(intent);
            }
        });

    }
}