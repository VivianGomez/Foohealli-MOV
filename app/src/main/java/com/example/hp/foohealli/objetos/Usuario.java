package com.example.hp.foohealli.objetos;

public class Usuario {

    public final static int HOMBRE=1;
    public final static int MUJER=2;


    private String nombres;
    private String apellidos;
    private int edad;
    private int peso;
    private int sexo;
    private int estadio;
    private ExamenesMedicos examenes;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, int edad, int peso, ExamenesMedicos examenes, int sexo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.examenes = examenes;
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

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }


    public ExamenesMedicos getExamenes() {
        return examenes;
    }

    public void setExamenes(ExamenesMedicos examenes) {
        this.examenes = examenes;
    }

    public int getEstadio() {
        return estadio;
    }

    public void setEstadio(int estadio) {
        this.estadio = estadio;
    }
}
