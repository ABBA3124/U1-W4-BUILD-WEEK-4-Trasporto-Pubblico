package org.gestionetrasportopubblico.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DistributoreAutomatico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String posizione;
    private boolean attivo;


    @OneToMany(mappedBy = "distributoreAutomatico")
    private List<Biglietto> biglietti;

    @OneToMany(mappedBy = "distributoreAutomatico")
    private List<Abbonamento> abbonamenti;

    public DistributoreAutomatico() {
    }


    public DistributoreAutomatico(String posizione, boolean attivo) {
        this.posizione = posizione;
        this.attivo = attivo;

    }

    public Long getId() {
        return id;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }


    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }


    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                "id=" + id +
                ", posizione='" + posizione + '\'' +
                ", attivo=" + attivo +
                ", biglietti=" + biglietti +
                '}';
    }
}
