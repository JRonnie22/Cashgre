package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class seppantalla extends AppCompatActivity {

    Button bfinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seppantalla);

        bfinalizar=(Button) findViewById(R.id.bfinalizar);

        bfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bfinalizar = new Intent(seppantalla.this, quinpantalla.class);
                startActivity(bfinalizar);
            }
        });
    }
}