package org.gestionetrasportopubblico.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tratte")
public class Tratta {

    //Attributi
    @Id
    @GeneratedValue
    private UUID id;

    private String partenza;
    private String capolinea;
    private double tempo_medio;


    @ManyToMany(mappedBy = "lista_tratte")
    private List<Mezzo> listaMezzi;

    //Costruttori
    public Tratta() {
    }

    public Tratta(String partenza, String capolinea, double tempo_medio) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.tempo_medio = tempo_medio;
    }
    //Metodi


    public UUID getId() {
        return id;
    }


    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public double getTempo_medio() {
        return tempo_medio;
    }

    public void setTempo_medio(double tempo_medio) {
        this.tempo_medio = tempo_medio;
    }

    public List<Mezzo> getListaMezzi() {
        return listaMezzi;
    }

    public void setListaMezzi(List<Mezzo> listaMezzi) {
        this.listaMezzi = listaMezzi;
    }


    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", partenza='" + partenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempo_medio=" + tempo_medio +
                ", listaMezzi=" + listaMezzi +
                '}';
    }
}
