package com.example.josesanjuanelo.tallerlistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class carroMasCaro extends AppCompatActivity {

    private ArrayList<Carro> carros;
    private TableLayout tabla;
    private String aux;
    private  int entero, precioMayor=0, c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_mas_caro);

        tabla = (TableLayout) findViewById(R.id.tblCarros);
        carros = Datos.getCarros();

        for (int i = 0; i < carros.size() ; i++) {
            entero = Integer.parseInt(carros.get(i).getPrecio());
            if (entero > precioMayor ){
                precioMayor = entero;
            }
        }

        for (int i = 0; i < carros.size() ; i++) {
            entero = Integer.parseInt(carros.get(i).getPrecio());
            if (entero == precioMayor ){
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
