package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class seppantalla extends AppCompatActivity {

    TextView nopedido;

    Button bfinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seppantalla);

        bfinalizar=(Button) findViewById(R.id.bfinalizar);
        nopedido=(TextView) findViewById(R.id.Nopedido);
        Intent recibircodigo=getIntent();
        String usuario=recibircodigo.getStringExtra("usuario");
        String codigo=recibircodigo.getStringExtra("codigo");
        nopedido.setText(codigo);

        bfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bfinalizar = new Intent(seppantalla.this, quinpantalla.class);
                bfinalizar.putExtra("usuario",usuario);
                startActivity(bfinalizar);
            }
        });
    }
}