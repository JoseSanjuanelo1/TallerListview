package com.example.josesanjuanelo.tallerlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jose Sanjuanelo on 05/05/2017.
 */

public class AdaptadorCarro extends BaseAdapter {

    private Context contexto;
    private ArrayList<Carro> carros;
    public AdaptadorCarro(Context contexto, ArrayList<Carro> carros) {
        this.contexto = contexto;
        this.carros = carros;
    }

    @Override

    public int getCount() { return carros.size(); }

    @Override

    public Object getItem(int position) { return carros.get(position); }

    @Override

    public long getItemId(int position) { return 0; }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        TextView placa, marca, modelo, precio;
        ImageView foto;
        LayoutInflater inflater;
        View ItemView;

        //Inflater
        inflater =(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ItemView = inflater.inflate(R.layout.item_carro, null);

        //captura objetos

        placa = (TextView)ItemView.findViewById(R.id.lblPlacaCarro);
        marca = (TextView)ItemView.findViewById(R.id.lblMarcaCarro);
        modelo = (TextView)ItemView.findViewById(R.id.lblModeloCarro);
        precio = (TextView)ItemView.findViewById(R.id.lblPrecioCarro);
        foto = (ImageView) ItemView.findViewById(R.id.imgFoto);

        //pasar objetos

        placa.setText(carros.get(position).getPlaca());
        marca.setText(carros.get(position).getMarca());
        modelo.setText(""+carros.get(position).getModelo());
        precio.setText(""+carros.get(position).getPrecio());
        foto.setImageResource(Integer.parseInt(carros.get(position).getFoto()));

        //retorno itemview

        return ItemView;
    }
}
