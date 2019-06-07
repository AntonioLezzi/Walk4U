package com.example.walk4you.Model;


import java.util.Date;


public class Ristorante {

    private int id_ristorante;
    private String nomeRistorante;
    private double latitudine;
    private double longitudine;
    private String tipologia;

    public String getTipologia() {
        return tipologia;
    }

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

