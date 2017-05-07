package com.example.josesanjuanelo.tallerlistview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Reportes extends AppCompatActivity {

    private ListView ls;
    private Resources res;
    private String [] opc;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        ls=(ListView)findViewById(R.id.lvReportes);
        res = this.getResources();
        opc = res.getStringArray(R.array.reporte);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,opc);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i = new Intent(Reportes.this, CarrosRegistrados.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Reportes.this, carroMasCaro.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(Reportes.this, carroMasEconomico.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
