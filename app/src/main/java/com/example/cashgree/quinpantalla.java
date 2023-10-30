package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quinpantalla extends AppCompatActivity {

    Button bsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinpantalla);

        bsalir=(Button) findViewById(R.id.bsalir);

        bsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bsalir = new Intent(quinpantalla.this, MainActivity.class);
                startActivity(bsalir);
            }
        });
    }
}