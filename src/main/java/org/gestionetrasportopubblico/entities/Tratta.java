package org.gestionetrasportopubblico.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tratte")
public class Tratta {

    //Attributi
    @Id
    @GeneratedValue
    private UUID id;

    private String zone_di_partenza;
    private String capolinea;
    private double tempo_medio;


    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Percorrenza percorrenza;


    //Costruttori
    public Tratta() {
    }

    public Tratta(String zone_di_partenza, String capolinea, double tempo_medio) {
        this.zone_di_partenza = zone_di_partenza;
        this.capolinea = capolinea;
        this.tempo_medio = tempo_medio;
    }

    public UUID getId() {
        return id;
    }


    public String getZone_di_partenza() {
        return zone_di_partenza;
    }

    public void setZone_di_partenza(String zone_di_partenza) {
        this.zone_di_partenza = zone_di_partenza;
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

    public Percorrenza getPercorrenza() {
        return percorrenza;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", zone_di_partenza='" + zone_di_partenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempo_medio=" + tempo_medio +
                ", percorrenza=" + percorrenza +
                '}';
    }
}
