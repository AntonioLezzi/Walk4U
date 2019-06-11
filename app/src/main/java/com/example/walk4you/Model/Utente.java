package com.example.walk4you.Model;


import com.google.gson.annotations.SerializedName;

import java.util.Date;



public class Utente {

    @SerializedName("mail")
    private String mail;
    @SerializedName("mail")
    private String nome;
    @SerializedName("mail")
    private String cognome;
    @SerializedName("mail")
    private float altezza;
    @SerializedName("mail")
    private String password;
    @SerializedName("mail")
    private boolean sesso_femminile;
    @SerializedName("mail")
    private Date data_di_nascita;
    @SerializedName("mail")
    private int punteggio_utente;
    @SerializedName("mail")
    private int livello_utente;

    public int getLivello_utente() { return livello_utente; }

    public void setLivello_utente(int livello_utente) {
        this.livello_utente = livello_utente;
    }

    public int getPunteggio_utente() { return punteggio_utente; }

    public void setPunteggio_utente(int punteggio_utente) { this.punteggio_utente = punteggio_utente; }

    public Date getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(Date data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public boolean isSesso_femminile() {
        return sesso_femminile;
    }

    public void setSesso_femminile(boolean sesso_femminile) { this.sesso_femminile = sesso_femminile; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getAltezza() {
        return altezza;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
