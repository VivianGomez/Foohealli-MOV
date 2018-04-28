package com.example.hp.foohealli.objetos;

import java.util.ArrayList;

public class Receta {

    private String nombre;
    private String descripcion;
    private String notasYrecomendaciones;
    private ArrayList<Ingrediente> ingredientes;
    private String comidaDelDia;
    private String imagen;

    public Receta() {
    }

    public Receta(String nombre, String descripcion, String notasYrecomendaciones, ArrayList<Ingrediente> ingredientes, String comidaDelDia, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.notasYrecomendaciones = notasYrecomendaciones;
        this.ingredientes = ingredientes;
        this.comidaDelDia = comidaDelDia;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getComidaDelDia() {
        return comidaDelDia;
    }

    public void setComidaDelDia(String comidaDelDia) {
        this.comidaDelDia = comidaDelDia;
    }

    public String getNotasYrecomendaciones() {
        return notasYrecomendaciones;
    }

    public void setNotasYrecomendaciones(String notasYrecomendaciones) {
        this.notasYrecomendaciones = notasYrecomendaciones;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
