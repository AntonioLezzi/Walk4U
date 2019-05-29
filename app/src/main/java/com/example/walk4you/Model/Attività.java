package com.example.walk4you.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Attività {

    @PrimaryKey (autoGenerate = true)
    private int id_attività;
    private int numero_passi;
    private Date data_inizio;
    private Date data_fine;
    private double ore_sonno;
    private double Km;
    private int Kcal_bruciate;


    public int getKcal_bruciate() { return Kcal_bruciate; }

    public void setKcal_bruciate(int kcal_bruciate) { Kcal_bruciate = kcal_bruciate; }

    public double getKm() {
        return Km;
    }

    public void setKm(double km) {
        Km = km;
    }

    public double getOre_sonno() {
        return ore_sonno;
    }

    public void setOre_sonno(double ore_sonno) {
        this.ore_sonno = ore_sonno;
    }

    public Date getData_fine() {
        return data_fine;
    }

    public void setData_fine(Date data_fine) {
        this.data_fine = data_fine;
    }

    public Date getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }

    public int getNumero_passi() {
        return numero_passi;
    }

    public void setNumero_passi(int numero_passi) {
        this.numero_passi = numero_passi;
    }

    public int getId_attività() {
        return id_attività;
    }

    public void setId_attività(int id_attività) {
        this.id_attività = id_attività;
    }

}

