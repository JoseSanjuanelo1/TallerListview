package com.example.josesanjuanelo.tallerlistview;

import java.util.ArrayList;

/**
 * Created by Jose Sanjuanelo on 05/05/2017.
 */

public class Datos {
    static ArrayList<Carro> carros = new ArrayList<>();

    public static void guardar(Carro c){
        carros.add(c);
    }

    public static ArrayList<Carro> getCarros() {
        return carros;
    }
}

