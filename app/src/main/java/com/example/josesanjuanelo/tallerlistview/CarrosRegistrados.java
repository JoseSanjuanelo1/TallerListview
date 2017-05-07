package com.example.josesanjuanelo.tallerlistview;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CarrosRegistrados extends AppCompatActivity {

    private ArrayList<Carro> carros;
    private TextView respuesta;
    Resources res;
    private int cont=0;

    public void contar(){

        carros = Datos.getCarros();
        cont = carros.size();
        new AlertDialog.Builder(this).setMessage(res.getString(R.string.cc)+": "+cont).show();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros_registrados);
        res = this.getResources();

        //respuesta = (TextView) findViewById(R.id.lblRes);

        contar();

    }
}
