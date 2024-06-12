package org.gestionetrasportopubblico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;


@Entity
public class Percorrenza {
    @Id
    @GeneratedValue
    private UUID id;


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

    public UUID getId() {
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
                ", mezzi=" + mezzi +
                ", tratte=" + tratte +
                ", tempo_effettivo=" + tempo_effettivo +
                ", numero_percorrenza=" + numero_percorrenza +
                '}';
    }
}
