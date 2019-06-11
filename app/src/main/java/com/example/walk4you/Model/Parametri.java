package com.example.walk4you.Model;


import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class Parametri {

    @SerializedName("id_parametri")
    private int id_parametri;
    @SerializedName("peso")
    private int peso;
    @SerializedName("battito_cardiaco")
    private int battito_cardiaco;
    @SerializedName("Saturazione_ossigeno")
    private int Saturazione_ossigeno;

    public int getSaturazione_ossigeno() {return Saturazione_ossigeno; }

    public void setSaturazione_ossigeno(int saturazione_ossigeno) {Saturazione_ossigeno = saturazione_ossigeno; }

    public int getBattito_cardiaco() {
        return battito_cardiaco;
    }

    public void setBattito_cardiaco(int battito_cardiaco) { this.battito_cardiaco = battito_cardiaco; }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getId_parametri() {
        return id_parametri;
    }

    public void setId_parametri(int id_parametri) { this.id_parametri = id_parametri;
    }
}