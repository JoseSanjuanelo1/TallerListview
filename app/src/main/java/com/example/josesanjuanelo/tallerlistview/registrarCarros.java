package com.example.josesanjuanelo.tallerlistview;

import android.content.res.Resources;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class registrarCarros extends AppCompatActivity {

    private EditText txtPlaca, txtPrecio;
    private Spinner cbxmarca, cbxmodelo, cbxcolor;
    private Resources res;
    private ArrayAdapter<String> ad1,ad2,ad3;
    private String [] opc1,opc2,opc3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_carros);

        res = this.getResources();
        txtPlaca = (EditText)findViewById(R.id.txtPlaca);
        txtPrecio = (EditText)findViewById(R.id.txtPrecio);
        cbxmarca = (Spinner)findViewById(R.id.spnMarca);
        cbxmodelo = (Spinner)findViewById(R.id.spnModelo);
        cbxcolor = (Spinner)findViewById(R.id.spnColor);

        opc1 = this.getResources().getStringArray(R.array.marca);
        opc2 = this.getResources().getStringArray(R.array.modelo);
        opc3 = this.getResources().getStringArray(R.array.color);

        ad1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc1);
        ad2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc2);
        ad3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opc3);

        cbxmarca.setAdapter(ad1);
        cbxmodelo.setAdapter(ad2);
        cbxcolor.setAdapter(ad3);

    }

    public void Registro(View v){
        String placa, marca, modelo, color, precio, foto="";
        if (validar()){
            placa = txtPlaca.getText().toString().trim();
            marca = cbxmarca.getSelectedItem().toString();
            modelo = cbxmodelo.getSelectedItem().toString();
            color = cbxcolor.getSelectedItem().toString();
            precio = txtPrecio.getText().toString().trim();

            if(carMarca()==0){
                foto = String.valueOf(valorFoto(5));
            }
            if(carMarca()==1){
                foto = String.valueOf(valorFoto(0));
            }
            if(carMarca()==2){
                foto = String.valueOf(valorFoto(2));
            }
            if(carMarca()==3){
                foto = String.valueOf(valorFoto(1));
            }
            if(carMarca()==4){
                foto = String.valueOf(valorFoto(3));
            }
            if(carMarca()==5){
                foto = String.valueOf(valorFoto(4));
            }

            Carro c = new Carro(foto, placa, marca, modelo, color, precio);
            c.guardar();
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje)).show();
            limpiar2();
        }
    }

    public void limpiar (View v){
        txtPlaca.setText("");
        txtPrecio.setText("");
        cbxmarca.setSelection(0);
        cbxmodelo.setSelection(0);
        cbxcolor.setSelection(0);
        txtPlaca.requestFocus();
    }

    public void limpiar2 (){
        txtPlaca.setText("");
        txtPrecio.setText("");
        cbxmarca.setSelection(0);
        cbxmodelo.setSelection(0);
        cbxcolor.setSelection(0);
        txtPlaca.requestFocus();
    }

    public int valorFoto(int x){
        int fotos[] = {R.drawable.chevolet, R.drawable.ferrari, R.drawable.kia, R.drawable.lamborghini, R.drawable.mazda, R.drawable.toyota};

        return  fotos[x];
    }

    public boolean validar(){
        if (txtPlaca.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            txtPlaca.setError(getResources().getString(R.string.error_1));
            return false;
        }

        if (txtPrecio.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            txtPrecio.setError(getResources().getString(R.string.error_2));
            return false;
        }
        return true;
    }

    public int carMarca(){
        int x=8;
        if (cbxmarca.getSelectedItem().toString().equals(getString(R.string.toyota))){
            x=0;
            return x;
        }
        if (cbxmarca.getSelectedItem().toString().equals(getString(R.string.chevrolet))){
            x=1;
            return x;
        }
        if (cbxmarca.getSelectedItem().toString().equals(getString(R.string.kia))){
            x=2;
            return x;
        }
        if (cbxmarca.getSelectedItem().toString().equals(getString(R.string.ferrari))){
            x=3;
            return x;
        }
        if (cbxmarca.getSelectedItem().toString().equals(getString(R.string.lambgn))){
            x=4;
            return x;
        }
        if (cbxmarca.getSelectedItem().toString().equals(getString(R.string.mazda))){
            x=5;
            return x;
        }
        return x;
    }
}
