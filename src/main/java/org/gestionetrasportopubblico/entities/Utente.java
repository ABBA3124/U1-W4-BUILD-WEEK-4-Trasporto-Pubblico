package org.gestionetrasportopubblico.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Utente {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    private String numeroTessera;
    private LocalDate dataScadenzaTessera;


    @OneToMany(mappedBy = "utente")
    //abbonamenti
    private List<Abbonamento> abbonamenti;


    public Utente() {
    }


    public Utente(String nome, String cognome, String numeroTessera, LocalDate dataScadenzaTessera, List<Abbonamento> abbonamenti) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTessera = numeroTessera;
        this.dataScadenzaTessera = dataScadenzaTessera;
        this.abbonamenti = abbonamenti;
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

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public LocalDate getDataScadenzaTessera() {
        return dataScadenzaTessera;
    }

    public void setDataScadenzaTessera(LocalDate dataScadenzaTessera) {
        this.dataScadenzaTessera = dataScadenzaTessera;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", numeroTessera='" + numeroTessera + '\'' +
                ", dataScadenzaTessera=" + dataScadenzaTessera +
                ", abbonamenti=" + abbonamenti +
                '}';
    }
}
