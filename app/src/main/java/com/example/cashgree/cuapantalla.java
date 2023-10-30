package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cuapantalla extends AppCompatActivity {

    Button butregistrarme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuapantalla);

        butregistrarme=(Button) findViewById(R.id.butregistrarme);

        butregistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent butregistrarme = new Intent(cuapantalla.this, MainActivity.class);
                startActivity(butregistrarme);
            }
        });
    }
}