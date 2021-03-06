package com.example.walk4you.Model;


import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class Attività {

    @SerializedName("id_attività")
    private int id_attività;
    @SerializedName("numero_passi")
    private int numero_passi;
    @SerializedName("data_inizio")
    private Date data_inizio;
    @SerializedName("data_fine")
    private Date data_fine;
    @SerializedName("ore_sonno")
    private double ore_sonno;
    @SerializedName("Km")
    private double Km;
    @SerializedName("Kcal_bruciate")
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

