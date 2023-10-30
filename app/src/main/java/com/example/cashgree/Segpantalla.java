package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Segpantalla extends AppCompatActivity {

    Button vender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segpantalla);

        vender=(Button) findViewById(R.id.vender);

        vender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vender = new Intent(Segpantalla.this, seppantalla.class);
                startActivity(vender);
            }
        });
    }
}