package org.gestionetrasportopubblico.entities;

public class Admin {

    private String nome;
    private String cognome;
    private String id_admin = "FS0224";
    private String livello = "Livello: 5 (MASTER)";
    private int codice = 1234;


    public Admin() {
    }


    public Admin(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getId_admin() {
        return id_admin;
    }


    public String getLivello() {
        return livello;
    }


    public int getCodice() {
        return codice;
    }

    @Override
    public String toString() {
        return "Benvenuto " +
                nome +
                " " + cognome + " " +
                "id_admin= " + id_admin + " " +
                "Autorizzazione: " + livello;
    }
}
