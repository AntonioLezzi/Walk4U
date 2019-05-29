package com.example.walk4you.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Parametri {

    @PrimaryKey (autoGenerate = true)
    private int id_parametri;
    private int peso;
    private int battito_cardiaco;
    private double latitudine;
    private double longitudine;

    public double getLatitudine() { return latitudine; }

    public void setLatitudine(double latitudine) { this.latitudine = latitudine; }

    public double getLongitudine() { return longitudine; }

    public void setLongitudine(double longitudine) { this.longitudine = longitudine; }

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