package com.example.walk4you.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Premi {

    @PrimaryKey(autoGenerate = true)
    private int id_premio;
    private String nome;
    private int numero_crediti;

    //Qr code
    public int getNumero_crediti() {
        return numero_crediti;
    }

    public void setNumero_crediti(int numero_crediti) {
        this.numero_crediti = numero_crediti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_premio() {
        return id_premio;
    }

    public void setId_premio(int id_premio) {
        this.id_premio = id_premio;
    }
}

