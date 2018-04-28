package com.example.hp.foohealli.objetos;

public class Ingrediente {

    private Alimento alimento;
    private double cantidad;

    public Ingrediente() {
    }

    public Ingrediente(Alimento alimento, double cantidad) {
        this.alimento = alimento;
        this.cantidad = cantidad;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
