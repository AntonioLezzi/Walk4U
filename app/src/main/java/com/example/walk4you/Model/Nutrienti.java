package com.example.walk4you.Model;


import com.google.gson.annotations.SerializedName;

public class Nutrienti {

    @SerializedName("id_alimento")
    private int id_alimento;
    @SerializedName("nome")
    private String nome;
    @SerializedName("grassi")
    private double grassi;
    @SerializedName("fibre")
    private double fibre;
    @SerializedName("vitamina_c")
    private double vitamina_c;
    @SerializedName("calcio")
    private double calcio;
    @SerializedName("sodio")
    private double sodio;
    @SerializedName("proteine")
    private double proteine;
    @SerializedName("potassio")
    private double potassio;
    @SerializedName("ferro")
    private double ferro;


    public double getFerro() {
        return ferro;
    }

    public void setFerro(double ferro) {
        this.ferro = ferro;
    }



    public double getPotassio() {
        return potassio;
    }

    public void setPotassio(double potassio) {
        this.potassio = potassio;
    }



    public double getProteine() {
        return proteine;
    }

    public void setProteine(double proteine) {
        this.proteine = proteine;
    }



    public double getSodio() {
        return sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }



    public double getCalcio() {
        return calcio;
    }

    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }



    public double getVitamina_c() {
        return vitamina_c;
    }

    public void setVitamina_c(double vitamina_c) {
        this.vitamina_c = vitamina_c;
    }



    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }



    public double getGrassi() {
        return grassi;
    }

    public void setGrassi(double grassi) {
        this.grassi = grassi;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(int id_alimento) {
        this.id_alimento = id_alimento;
    }
}


