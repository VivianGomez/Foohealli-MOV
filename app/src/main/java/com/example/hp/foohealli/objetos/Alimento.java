package com.example.hp.foohealli.objetos;

import java.util.ArrayList;

public class Alimento {

    private String nombre;
    private ArrayList<String> categorias;
    private String imagen;

    //APORTE POR RACIÓN
    private double proteina; //en g
    private double hidratosCarbono; //en g
    private double fibra; //en g
    private double grasaTotal; //en g
    private double colesterol; //en mg
    private double alcohol; //en g
    private double agua; //en g

    // MINERALES en mg
    private double calcio; //**
    private double hierro;
    private double sodio;
    private double potasio;
    private double fosforo;

    //VITAMINAS, PARA REGULAR EL METABOLISMO
    /*
    el riñón es el encargado de activar la vitamina D procedente de los alimentos, para así, poder absorber el calcio de la comida. Cuando el riñón no funciona, no se activa esta vitamina y
    no se puede utilizar el calcio presente en los alimentos. Existen medicamentos que aportan vitamina D activa para mejorar la absorción del calcio
     */
    private double vitaminaD; //**
    private double vitaminaA;
    private double vitaminaC;

    public Alimento() {
    }

    public Alimento(String nombre, ArrayList<String> categorias, String imagen, double proteina, double hidratosCarbono, double fibra, double grasaTotal, double colesterol, double alcohol, double agua, double calcio, double hierro, double sodio, double potasio, double fosforo, double vitaminaD, double vitaminaA, double vitaminaC) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.imagen = imagen;
        this.proteina = proteina;
        this.hidratosCarbono = hidratosCarbono;
        this.fibra = fibra;
        this.grasaTotal = grasaTotal;
        this.colesterol = colesterol;
        this.alcohol = alcohol;
        this.agua = agua;
        this.calcio = calcio;
        this.hierro = hierro;
        this.sodio = sodio;
        this.potasio = potasio;
        this.fosforo = fosforo;
        this.vitaminaD = vitaminaD;
        this.vitaminaA = vitaminaA;
        this.vitaminaC = vitaminaC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getHidratosCarbono() {
        return hidratosCarbono;
    }

    public void setHidratosCarbono(double hidratosCarbono) {
        this.hidratosCarbono = hidratosCarbono;
    }

    public double getFibra() {
        return fibra;
    }

    public void setFibra(double fibra) {
        this.fibra = fibra;
    }

    public double getGrasaTotal() {
        return grasaTotal;
    }

    public void setGrasaTotal(double grasaTotal) {
        this.grasaTotal = grasaTotal;
    }

    public double getColesterol() {
        return colesterol;
    }

    public void setColesterol(double colesterol) {
        this.colesterol = colesterol;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public double getCalcio() {
        return calcio;
    }

    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }

    public double getHierro() {
        return hierro;
    }

    public void setHierro(double hierro) {
        this.hierro = hierro;
    }

    public double getSodio() {
        return sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public double getPotasio() {
        return potasio;
    }

    public void setPotasio(double potasio) {
        this.potasio = potasio;
    }

    public double getFosforo() {
        return fosforo;
    }

    public void setFosforo(double fosforo) {
        this.fosforo = fosforo;
    }

    public double getVitaminaD() {
        return vitaminaD;
    }

    public void setVitaminaD(double vitaminaD) {
        this.vitaminaD = vitaminaD;
    }

    public double getVitaminaA() {
        return vitaminaA;
    }

    public void setVitaminaA(double vitaminaA) {
        this.vitaminaA = vitaminaA;
    }

    public double getVitaminaC() {
        return vitaminaC;
    }

    public void setVitaminaC(double vitaminaC) {
        this.vitaminaC = vitaminaC;
    }
}
