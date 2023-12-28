package com.example.cashgree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Segpantalla extends AppCompatActivity {
    double preciopapel=500.0/1000.0;
    double precioplastico=1500.0/1000.0;
    double preciocarton=1000.0/1000.0;
    double preciomadera=3000.0/1000.0;
    double preciohierro=2500.0/1000.0;
    double precioaluminio=2000.0/1000.0;
    double preciopilas=3500.0/1000.0;

    Button vender,calcular;
    String valorpapel,valorplastico,valorcarton,valormadera,valorhierro,valoraluminio,valorpilas,valortotal,valorpreciototal;

    EditText papel,plastico,carton,madera,hierro,aluminio,pilas;
    TextView totalpapel,totalplastico,totalcarton,totalmadera,totalhierro,totalaluminio,totalpilas,totalgramos,totalprecio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segpantalla);

        vender=(Button) findViewById(R.id.vender);
        calcular=findViewById(R.id.calcular);
        papel=findViewById(R.id.etpapel);
        totalpapel=findViewById(R.id.totalpapel);
        plastico=findViewById(R.id.etplastico);
        totalplastico=findViewById(R.id.totalplastico);
        carton=findViewById(R.id.etcarton);
        totalcarton=findViewById(R.id.totalcarton);
        madera=findViewById(R.id.etmadera);
        totalmadera=findViewById(R.id.totalmadera);
        hierro=findViewById(R.id.ethierro);
        totalhierro=findViewById(R.id.totalhierro);
        aluminio=findViewById(R.id.etaluminio);
        totalaluminio=findViewById(R.id.totalaluminio);
        pilas=findViewById(R.id.etpilas);
        totalpilas=findViewById(R.id.totalpilas);
        totalgramos=findViewById(R.id.tvtotalg);
        totalprecio=findViewById(R.id.preciototal);
        Intent recibirusuario=getIntent();
        String usuario=recibirusuario.getStringExtra("usuario");

calcular.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        valorpapel=calcularpapel(papel.getText().toString());
        valorplastico=calcularplastico(plastico.getText().toString());
        valorcarton=calcularcarton(carton.getText().toString());
        valormadera=calcularmadera(madera.getText().toString());
        valorhierro=calcularhierro(hierro.getText().toString());
        valoraluminio=calcularaluminio(aluminio.getText().toString());
        valorpilas=calcularpilas(pilas.getText().toString());
    }
});
        vender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo=generarcodigo();

                 valortotal=totalgramos.getText().toString();
                 valorpreciototal= totalprecio.getText().toString();
                ReciclarModel reciclar=new ReciclarModel(papel.getText().toString(),plastico.getText().toString(),carton.getText().toString(),
                        madera.getText().toString(),hierro.getText().toString(),aluminio.getText().toString(),pilas.getText().toString(),
                        valortotal,valorpreciototal,valorpapel,valorplastico,valorcarton,valormadera,valorhierro,valoraluminio,valorpilas,codigo,usuario);


                guardarinformacion(reciclar);
                Intent vender = new Intent(Segpantalla.this, seppantalla.class);
                vender.putExtra("codigo",codigo);
                vender.putExtra("usuario",usuario);
                startActivity(vender);
            }
        });

    }
    public String generarcodigo(){
        String codigo="";
        for (int i=0;i<8;i++){
            codigo+=((int)(Math.random()*10));
        }
        return codigo;
    }

    public String calcularpapel(String cantidad){
        int cantidadnumero=Integer.parseInt(cantidad);
        double calculo=cantidadnumero*preciopapel;
        totalpapel.setText(calculo+"");
        System.out.println(calculo+" - "+cantidadnumero+" - "+preciopapel);
        totales(cantidadnumero,calculo);
        return calculo+"";

    }
    public String calcularplastico(String cantidad){
        int cantidadnumero=Integer.parseInt(cantidad);
        double calculo=cantidadnumero*precioplastico;
        totalplastico.setText(calculo+"");
        totales(cantidadnumero,calculo);
        return calculo+"";

    }
    public String calcularcarton(String cantidad){
        int cantidadnumero=Integer.parseInt(cantidad);
        double calculo=cantidadnumero*preciocarton;
        totalcarton.setText(calculo+"");
        totales(cantidadnumero,calculo);
        return calculo+"";

    }
    public String calcularmadera(String cantidad){
        int cantidadnumero=Integer.parseInt(cantidad);
        double calculo=cantidadnumero*preciomadera;
        totalmadera.setText(calculo+"");
        totales(cantidadnumero,calculo);
        return calculo+"";

    }
    public String calcularhierro(String cantidad){
        int cantidadnumero=Integer.parseInt(cantidad);
        double calculo=cantidadnumero*preciohierro;
        totalhierro.setText(calculo+"");
        totales(cantidadnumero,calculo);
        return calculo+"";

    }
    public String calcularaluminio(String cantidad){
        int cantidadnumero=Integer.parseInt(cantidad);
        double calculo=cantidadnumero*precioaluminio;
        totalaluminio.setText(calculo+"");
        totales(cantidadnumero,calculo);
        return calculo+"";

    }
    public String calcularpilas(String cantidad){
        int cantidadnumero=Integer.parseInt(cantidad);
        double calculo=cantidadnumero*preciopilas;
        totalpilas.setText(calculo+"");
        totales(cantidadnumero,calculo);
        return calculo+"";

    }
    public void totales(int cantidad,double precio){
        if (totalgramos.getText().toString().isEmpty()){
            totalgramos.setText(cantidad+"");
        }else {
            int cantidadactual=Integer.parseInt(totalgramos.getText().toString());
            totalgramos.setText((cantidadactual+cantidad)+"");
        }
        if (totalprecio.getText().toString().isEmpty()){
            totalprecio.setText(precio+"");
        }else {
            double precioactual=Double.parseDouble(totalprecio.getText().toString());
            totalprecio.setText((precioactual+precio)+"");
        }
    }
    public void guardarinformacion(ReciclarModel reciclar){
        File archivo=new File(getFilesDir(),"reciclar.txt");
        try {
            FileWriter escribir=new FileWriter(archivo,true);
            BufferedWriter escribirrapido=new BufferedWriter(escribir);
            escribirrapido.write(
                    reciclar.getPapel()+","+
                            reciclar.getTotalpapel()+","+
                            reciclar.getPlastico()+","+
                            reciclar.getTotalplastico()+","+
                            reciclar.getCarton()+","+
                            reciclar.getTotalcarton()+","+
                            reciclar.getMadera()+","+
                            reciclar.getTotalmadera()+","+
                            reciclar.getHierro()+","+
                            reciclar.getTotalhierro()+","+
                            reciclar.getAluminio()+","+
                            reciclar.getTotalaluminio()+","+
                            reciclar.getPilas()+","+
                            reciclar.getTotalpilas()+","+
                            reciclar.getTotalgramos()+","+
                            reciclar.getTotalprecio()+","+
                            reciclar.getCodigo()+","+
                            reciclar.getUsuario()
            );
            escribirrapido.newLine();
            escribirrapido.close();
        }catch (Exception error){
            error.printStackTrace();
        }
    }
}