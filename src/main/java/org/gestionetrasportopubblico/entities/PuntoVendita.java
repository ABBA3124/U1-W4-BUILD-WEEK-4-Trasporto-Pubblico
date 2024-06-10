package org.gestionetrasportopubblico.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class PuntoVendita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String indirizzo;


    @OneToMany(mappedBy = "puntoVendita")
    private List<Biglietto> biglietti;

    @OneToMany(mappedBy = "puntoVendita")
    private List<Abbonamento> abbonamenti;

    public PuntoVendita() {
    }

    public PuntoVendita(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }


    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }


    @Override
    public String toString() {
        return "PuntoVendita{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", biglietti=" + biglietti +
                '}';
    }
}
