package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Terpantalla extends AppCompatActivity {

    Button instruciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terpantalla);

        instruciones=(Button) findViewById(R.id.instruciones);
        Intent recibiremail=getIntent();
        String email=recibiremail.getStringExtra("usuario");

        instruciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instruciones = new Intent(Terpantalla.this, Segpantalla.class);
                instruciones.putExtra("usuario",email);
                startActivity(instruciones);
            }
        });
    }
}