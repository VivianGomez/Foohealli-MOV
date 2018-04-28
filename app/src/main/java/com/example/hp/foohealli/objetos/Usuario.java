package com.example.hp.foohealli.objetos;

public class Usuario {

    private String nombres;
    private String apellidos;
    private int edad;
    private int peso;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, int edad, int peso) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.peso = peso;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
