package org.gestionetrasportopubblico.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Percorrenza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "percorrenza")
    private List<Mezzo> mezzi;


    @OneToMany(mappedBy = "percorrenza")
    private List<Tratta> tratte;

    private double tempo_effettivo;


    private int numero_percorrenza;


    public Percorrenza() {
    }

    public Percorrenza(double tempo_effettivo) {
        this.tempo_effettivo = tempo_effettivo;

    }

    public Long getId() {
        return id;
    }

    public List<Mezzo> getMezzi() {
        return mezzi;
    }


    public List<Tratta> getTratte() {
        return tratte;
    }


    public double getTempo_effettivo() {
        return tempo_effettivo;
    }

    public void setTempo_effettivo(double tempo_effettivo) {
        this.tempo_effettivo = tempo_effettivo;
    }

    public int getNumero_percorrenza() {
        return numero_percorrenza;
    }

    @Override
    public String toString() {
        return "Percorrenza{" +
                "id=" + id +
                
                ", tratte=" + tratte +
                ", tempo_effettivo=" + tempo_effettivo +
                ", numero_percorrenza=" + numero_percorrenza +
                '}';
    }
}
