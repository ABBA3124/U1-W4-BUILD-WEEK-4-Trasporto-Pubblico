package org.gestionetrasportopubblico.entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Utente {
    @OneToMany(mappedBy = "utente")
    List<Biglietto> listaBiglietti;
    @OneToMany(mappedBy = "utente")
    List<Abbonamento> listaAbbonamenti;
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    @OneToOne(mappedBy = "utente")
    private Tessera numeroTessera;

    public Utente() {
    }

    public Utente(String nome, String cognome, Tessera numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTessera = numeroTessera;
    }

    public UUID getId() {
        return id;
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

    public Tessera getNumeroTessera() {
        return numeroTessera;
    }

    public List<Biglietto> getListaBiglietti() {
        return listaBiglietti;
    }

    public List<Abbonamento> getListaAbbonamenti() {
        return listaAbbonamenti;
    }


    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
