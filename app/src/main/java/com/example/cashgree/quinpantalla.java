package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class quinpantalla extends AppCompatActivity {

    Button bsalir;
    TextView total;
    TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinpantalla);

        bsalir=(Button) findViewById(R.id.bsalir);
        total=findViewById(R.id.tvtotalganancias);
        tabla=findViewById(R.id.tabla);
        Intent recibirusuario=getIntent();
        String usuario=recibirusuario.getStringExtra("usuario");
        ArrayList<ReciclarModel>pedidos=traerpedidos(usuario);
        llenartabla(pedidos);
        calculartotal(pedidos);


        bsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bsalir = new Intent(quinpantalla.this, MainActivity.class);
                startActivity(bsalir);
            }
        });
    }
    public ArrayList<ReciclarModel>traerpedidos(String usuario){
        ArrayList<ReciclarModel>lista=new ArrayList<>();
        File archivo=new File(getFilesDir(),"reciclar.txt");
        try {
            FileReader leer=new FileReader(archivo);
            BufferedReader leerrapido=new BufferedReader(leer);
            String registro;
            while ((registro=leerrapido.readLine())!=null){
                String []datos=registro.split(",");
                if (usuario.equals(datos[datos.length-1])){
                    String papel=datos[0];
                    String totalpapel=datos[1];
                    String plastico=datos[2];
                    String totalplastico=datos[3];
                    String carton=datos[4];
                    String totalcarton=datos[5];
                    String madera=datos[6];
                    String totalmadera=datos[7];
                    String hierro=datos[8];
                    String totalhierro=datos[9];
                    String aluminio=datos[10];
                    String totalaluminio=datos[11];
                    String pilas=datos[12];
                    String totalpilas=datos[13];
                    String totalgramos=datos[14];
                    String totalprecio=datos[15];
                    String codigo=datos[16];
                    ReciclarModel pedido=new ReciclarModel(papel,plastico,carton,madera,hierro,aluminio,pilas,totalgramos,totalprecio,totalpapel,
                            totalplastico,totalcarton,totalmadera,totalhierro,totalaluminio,totalpilas,codigo,usuario);
                    lista.add(pedido);
                }
            }
        }catch (Exception problema){
            problema.printStackTrace();
        }
        return lista;

    }
    public void llenartabla(ArrayList<ReciclarModel>pedidos){
        for (ReciclarModel i:pedidos){
            TableRow fila=new TableRow(this);
            TextView nopedido=new TextView(this);
            nopedido.setWidth(130);
            nopedido.setText(i.getCodigo());
            TextView estado=new TextView(this);
            estado.setWidth(130);
            estado.setText("P");
            TextView totalganancia=new TextView(this);
            totalganancia.setWidth(135);
            totalganancia.setText(i.getTotalprecio());
            fila.addView(nopedido);
            fila.addView(estado);
            fila.addView(totalganancia);
            tabla.addView(fila);
        }
    }
    public void  calculartotal(ArrayList<ReciclarModel>lista){
        double totalprecio=0;
        for (ReciclarModel i:lista){
            totalprecio+=Double.parseDouble(i.getTotalprecio());

        }total.setText(totalprecio+"");

    }
}