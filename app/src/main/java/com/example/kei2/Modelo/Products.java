package com.example.kei2.Modelo;

public class Products {
    private int imagen;
    private String nombre;
    private int vendido;

    public Products(int imagen, String nombre, int vendido)
    {
        this.imagen = imagen;
        this.nombre = nombre;
        this.vendido = vendido;
    }

    public int getImagen() {
        return imagen;
    }
    public String getNombre()
    {
        return nombre;
    }
    public int getVisitas()
    {
        return vendido;
    }
}
