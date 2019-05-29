package com.example.walk4you.Model;


import java.util.Date;


public class Ristorante {

    private int id_ristorante;
    private double latitudine;
    private double longitudine;
    private String tipologia;

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

    public int getId_ristorante() {
        return id_ristorante;
    }

    public void setId_ristorante(int id_ristorante) {
        this.id_ristorante = id_ristorante;
    }
}
