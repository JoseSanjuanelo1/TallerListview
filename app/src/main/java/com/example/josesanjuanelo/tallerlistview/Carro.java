package com.example.josesanjuanelo.tallerlistview;

/**
 * Created by Jose Sanjuanelo on 05/05/2017.
 */

public class Carro {

    private String foto;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String precio;

    public Carro(String foto, String placa, String marca, String modelo, String color, String precio) {
        this.foto = foto;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }

    public String getFoto() { return foto; }

    public void setFoto(String foto) { this.foto = foto; }

    public String getPlaca() { return placa; }

    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public String getPrecio() { return precio; }

    public void setPrecio(String precio) { this.precio = precio; }

    public void guardar() {Datos.guardar(this);}
}
