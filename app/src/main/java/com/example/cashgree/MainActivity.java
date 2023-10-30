package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button butIngresar;
    TextView tvolvidecontraseña;

    TextView tvNotengocuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNotengocuenta=(TextView) findViewById(R.id.tvNotengocuenta);

        tvNotengocuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvNotengocuenta = new Intent(MainActivity.this, cuapantalla.class);
                startActivity(tvNotengocuenta);
            }
        });

        tvolvidecontraseña=(TextView) findViewById(R.id.tvolvidecontraseña);

        tvolvidecontraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tvolvidecontraseña = new Intent(MainActivity.this, sextpantalla.class);
                startActivity(tvolvidecontraseña);
            }
        });

        butIngresar=(Button) findViewById(R.id.butIngresar);

        butIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent butIngresar = new Intent(MainActivity.this, Terpantalla.class);
                startActivity(butIngresar);
            }
        });
    }
}