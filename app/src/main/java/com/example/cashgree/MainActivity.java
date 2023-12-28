package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button butIngresar;
    TextView tvolvidecontraseña;

    TextView tvNotengocuenta;

    EditText usuario,contrasena;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=findViewById(R.id.etCorreo);
        contrasena=findViewById(R.id.etContrasena);

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
        File archivousuario=new File(getFilesDir(),"usuario.txt");
        ArrayList <UserModel>listausuario=listarusuarios(archivousuario);

        butIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usuario.getText().toString().isEmpty()||contrasena.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Todos los campos deben diligenciarse",Toast.LENGTH_LONG).show();
                }
                else {
                    String correousuario=usuario.getText().toString();
                    String contrasenausuario=contrasena.getText().toString();
                    for(UserModel i:listausuario){
                        if(i.getEmail().equals(correousuario) && i.getContrasena().equals(contrasenausuario)){
                            Intent butIngresar = new Intent(MainActivity.this, Terpantalla.class);
                            butIngresar.putExtra("usuario",correousuario);
                            startActivity(butIngresar);
                            break;
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"La informacion ingresada es incorrecta",Toast.LENGTH_LONG).show();
                        }
                    }
                }

            }
        });
    }
    public ArrayList<UserModel>listarusuarios(File archivo){
        ArrayList<UserModel>lista=new ArrayList<>();
        try {
            FileReader leer=new FileReader(archivo);
            BufferedReader leerrapido=new BufferedReader(leer);
            String usuario;
            while((usuario=leerrapido.readLine())!=null){
                String []usuarios=usuario.split(",");
                String nombre=usuarios[0];
                String correo=usuarios[2];
                String documento=usuarios[1];
                String celular=usuarios[3];
                String contrasena=usuarios[4];
                UserModel datosusuario=new UserModel(nombre,correo,documento,contrasena,celular);
                lista.add(datosusuario);
            }

        }catch (Exception error){
            error.printStackTrace();}
        return lista;
    }
}