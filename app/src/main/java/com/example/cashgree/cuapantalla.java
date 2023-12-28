package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class cuapantalla extends AppCompatActivity {

    Button butregistrarme;
    EditText nombre,documento,email,contrasena,celular;
    String nombreTexto,documentoTexto,emailTexto,contrasenaTexto,celulatTexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuapantalla);

        butregistrarme=(Button) findViewById(R.id.butregistrarme);
        nombre=findViewById(R.id.etnombre);
        documento=findViewById(R.id.etcedula);
        email=findViewById(R.id.etemail);
        contrasena=findViewById(R.id.etdireccion);
        celular=findViewById(R.id.etcelular);

        butregistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombreTexto=nombre.getText().toString();
                documentoTexto=documento.getText().toString();
                emailTexto=email.getText().toString();
                contrasenaTexto=contrasena.getText().toString();
                celulatTexto=celular.getText().toString();
                if(nombreTexto.isEmpty()||documentoTexto.isEmpty()||emailTexto.isEmpty()||contrasenaTexto.isEmpty()||celulatTexto.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Todos los campos deben diligenciarse",Toast.LENGTH_LONG).show();
                }
                else {
                    UserModel user=new UserModel(nombreTexto,emailTexto,documentoTexto,contrasenaTexto,celulatTexto);
                      almacenarusuario(user);
                    Intent butregistrarme = new Intent(cuapantalla.this, MainActivity.class);
                    startActivity(butregistrarme);
                }

            }
        });
    }
    public void almacenarusuario(UserModel user){
        File archivoUsuario=new File(getFilesDir(),"usuario.txt");
        try{
            FileWriter escribir=new FileWriter(archivoUsuario,true);
            BufferedWriter escribirrapido=new BufferedWriter(escribir);
            escribirrapido.write(
                    user.getNombre()+","+
                            user.getDocumento()+","+
                            user.getEmail()+","+
                            user.getCelular()+","+
                            user.getContrasena()
            );
            escribirrapido.newLine();
            escribirrapido.close();
        }catch (Exception error){
            error.printStackTrace();
        }
    }
}
