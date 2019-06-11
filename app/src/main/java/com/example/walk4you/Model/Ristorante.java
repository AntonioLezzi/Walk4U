package com.example.walk4you.Model;


import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class Ristorante {

    @SerializedName("id_ristorante")
    private int id_ristorante;
    @SerializedName("nomeRistorante")
    private String nomeRistorante;
    @SerializedName("latitudine")
    private double latitudine;
    @SerializedName("longitudine")
    private double longitudine;
    @SerializedName("tipologia")
    private String tipologia;

    public int getId_ristorante() {return id_ristorante; }

    public void setId_ristorante(int id_ristorante) {this.id_ristorante = id_ristorante; }

    public String getTipologia() { return tipologia; }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public String getNomeRistorante() { return nomeRistorante;
    }
    public void setNomeRistorante(String nomeRistorante) { this.nomeRistorante = nomeRistorante;
    }
}

