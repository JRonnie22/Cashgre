package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sextpantalla extends AppCompatActivity {

    Button brestablecer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sextpantalla);

        brestablecer=(Button) findViewById(R.id.brestablecer);

        brestablecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brestablecer = new Intent(sextpantalla.this, MainActivity.class);
                startActivity(brestablecer);
            }
        });
    }
}