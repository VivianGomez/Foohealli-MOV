package com.example.hp.foohealli.objetos;

public class ExamenesMedicos {

    private double TGF;
    private double glucosa;
    private double acidoUrico;
    private double albumina;
    private double potasio;
    private double sodio;
    private double fosforo;
    private double proteinasOrina;
    private double colesterolTotal;
    private double nitrogenoUreico;
    private double creatinina;
    private double presionArterial;
    private double trigliceridos;


    public ExamenesMedicos() {
    }

    public ExamenesMedicos(double TGF, double glucosa, double acidoUrico, double albumina, double potasio, double sodio, double fosforo, double proteinasOrina, double colesterolTotal, double nitrogenoUreico, double creatinina, double presionArterial, double trigliceridos) {
        this.TGF = TGF;
        this.glucosa = glucosa;
        this.acidoUrico = acidoUrico;
        this.albumina = albumina;
        this.potasio = potasio;
        this.sodio = sodio;
        this.fosforo = fosforo;
        this.proteinasOrina = proteinasOrina;
        this.colesterolTotal = colesterolTotal;
        this.nitrogenoUreico = nitrogenoUreico;
        this.creatinina = creatinina;
        this.presionArterial = presionArterial;
        this.trigliceridos = trigliceridos;
    }

    public double getTGF() {
        return TGF;
    }

    public void setTGF(double TGF) {
        this.TGF = TGF;
    }

    public double getGlucosa() {
        return glucosa;
    }

    public void setGlucosa(double glucosa) {
        this.glucosa = glucosa;
    }

    public double getAcidoUrico() {
        return acidoUrico;
    }

    public void setAcidoUrico(double acidoUrico) {
        this.acidoUrico = acidoUrico;
    }

    public double getAlbumina() {
        return albumina;
    }

    public void setAlbumina(double albumina) {
        this.albumina = albumina;
    }

    public double getPotasio() {
        return potasio;
    }

    public void setPotasio(double potasio) {
        this.potasio = potasio;
    }

    public double getSodio() {
        return sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public double getFosforo() {
        return fosforo;
    }

    public void setFosforo(double fosforo) {
        this.fosforo = fosforo;
    }

    public double getProteinasOrina() {
        return proteinasOrina;
    }

    public void setProteinasOrina(double proteinasOrina) {
        this.proteinasOrina = proteinasOrina;
    }

    public double getColesterolTotal() {
        return colesterolTotal;
    }

    public void setColesterolTotal(double colesterolTotal) {
        this.colesterolTotal = colesterolTotal;
    }

    public double getNitrogenoUreico() {
        return nitrogenoUreico;
    }

    public void setNitrogenoUreico(double nitrogenoUreico) {
        this.nitrogenoUreico = nitrogenoUreico;
    }

    public double getCreatinina() {
        return creatinina;
    }

    public void setCreatinina(double creatinina) {
        this.creatinina = creatinina;
    }

    public double getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(double presionArterial) {
        this.presionArterial = presionArterial;
    }

    public double getTrigliceridos() {
        return trigliceridos;
    }

    public void setTrigliceridos(double trigliceridos) {
        this.trigliceridos = trigliceridos;
    }
}
