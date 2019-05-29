package com.example.walk4you.Model;


import java.util.Date;



public class Pasto {

    private int id_pasto;
    private boolean cena;
    private boolean colazione;
    private boolean pranzo;
    private boolean spuntino;
    private Date data_inizio;
    private Date data_fine;
    private String alimento;

    public int getId_pasto() {
        return id_pasto;
    }

    public void setId_pasto(int id_pasto) {
        this.id_pasto = id_pasto;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
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

    public boolean isSpuntino() {
        return spuntino;
    }

    public void setSpuntino(boolean spuntino) {
        this.spuntino = spuntino;
    }

    public boolean isPranzo() {
        return pranzo;
    }

    public void setPranzo(boolean pranzo) {
        this.pranzo = pranzo;
    }

    public boolean isColazione() {
        return colazione;
    }

    public void setColazione(boolean colazione) {
        this.colazione = colazione;
    }

    public boolean isCena() {
        return cena;
    }

    public void setCena(boolean cena) {
        this.cena = cena;
    }
}
