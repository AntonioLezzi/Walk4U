package com.example.walk4you.util;

import android.content.Context;

import com.example.walk4you.Adapter.AdapterUtente;

import java.sql.Date;

public class Constants {

    //tabella utente
    public static final String TABELLA_UTENTE  = "tabella_utente";
    public static final String MAIL = "mail";
    public static final String NOME = "nome";
    public static final String COGNOME = "cognome";
    public static final String PASSWORD = "password";
    public static final String ALTEZZA = "altezza";
    public static final String PESO = "peso";
    public static final String SESSO = "Sesso";
    public static final String DATA_NASCITA ="data nascita";
    public static final String ID_UTENTE = "id_utente";


    // tabella nutrienti
    public static final String TABELLA_NUTRIENTI = "Nutrienti";
    public static final String ID_NUTRIENTI = "id_nutrienti";
    public static final String GRASSI_SATURI = "Grassi_sauri";
    public static final String FIBRE = "fibre";
    public static final String PROTEINE = "proteine";
    public static final String POTASSIO = "potassio";
    public static final String FERRO = "ferro";
    public static final String VITAMINA_A = "vitamia_A";
    public static final String VITAMINA_C = "vitamina_C";
    public static final String SODIO = "sodio";


    // Tabella alimenti
    public static final String TABELLA_ALIMENTI = "alimenti";
    public static final String ID_ALIMENTI = "id_alimenti";
    public static final String INGREDIENTI = "ingredienti";
    public static final String CODICE_A_BARRE = "codice_barre";

    // Ristoranti
    public static final String TABELLA_RISTORANTI = "ristorante";
    public static final String ID_RISTORANTE = "id_ristorante";
    public static final String NOME_RISTORANTE = "Nome_ristorante";
    public static final String TIPOLOGIA_RISTORANTE = "tipologia_ristorante";
    public static final String DESCRIZIONE = "descrizione";
    public static final String POSIZIONE_GPS_LAT= "posizione_gps_lat";
    public static final String POSIZIONE_GPS_LONG= "posizione_gps_long";

    //premi
    public static final String TABELLA_PREMI = "premi";
    public static final String ID_PREMI = "id_premo";
    public static final String QR_CODE = "codice_QR";
    public static final String NOME_PREMIO = "Nome_Premio";
    public static final String PUNTEGGIO_PREMI = "punteggio_premi";
    public static final String LIVELLO_PREMI = "livello_premi";

    //pasti
    public static final String TABELLA_PASTI = "tabella_pasti";
    public static final String ID_PASTO = "id_pasti";
    public static final String CENA = "cena";
    public static final String COLAZIONE = "colazione";
    public static final String PRANZO = "pranzo";
    public static final String SPUNTINO = "spuntino";
    public static final String DATA_INIZIO = "data";
    public static final String DATA_FINE = "data_fine";
    public static final String ALIMENTO = "alimento";

    //attività
    public static final String TABELLA_ATTIVITA = "attività";
    public static final String ID_ATTIVITA = "id_attività";
    public static final String NUMERO_PASSO = "numero_passi";
    public static final String DATA_INIZIO_ATT = "data_inizio";
    public static final String DATA_FINE_ATT = "data_fine";
    public static final String ORE_SONNO = "ore_sonno";
    public static final String KM = "km";
    public static final String KCAL_BRUCIATE = "kcal_bruciate";

    //parametri
    public static final String TABELLA_PARAMETRI = "parametri";
    public static final String ID_PARAMETRI = "id_parametri";
    public static final String BATTITO_CARDIACO = "battito_cardiaco";
    public static final String SATURAZIONE_OSSIGENO = "saturazione_ossigeno";
}

