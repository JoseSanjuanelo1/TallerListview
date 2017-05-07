package com.example.josesanjuanelo.tallerlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class carroMasEconomico extends AppCompatActivity {

    private ArrayList<Carro> carros;
    private TableLayout tabla;
    private String aux;
    private  int entero, precioMenor=999999999, c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_mas_economico);

        tabla = (TableLayout) findViewById(R.id.tblCarros2);
        carros = Datos.getCarros();

        for (int i = 0; i < carros.size() ; i++) {
            entero = Integer.parseInt(carros.get(i).getPrecio());
            if (entero < precioMenor){
                precioMenor = entero;
            }
        }

        for (int i = 0; i < carros.size() ; i++) {
            entero = Integer.parseInt(carros.get(i).getPrecio());
            if (entero == precioMenor){
                TableRow fila = new TableRow(this);
                TextView c1 = new TextView(this);
                TextView c2 = new TextView(this);
                TextView c3 = new TextView(this);
                TextView c4 = new TextView(this);
                TextView c5 = new TextView(this);

                c1.setText("" + (c + 1));
                c2.setText(carros.get(i).getPlaca());
                c3.setText(carros.get(i).getMarca());
                c4.setText(carros.get(i).getModelo());
                c5.setText(carros.get(i).getPrecio());

                fila.addView(c1);
                fila.addView(c2);
                fila.addView(c3);
                fila.addView(c4);
                fila.addView(c5);

                tabla.addView(fila);
                c=c+1;
            }
        }
    }
}
