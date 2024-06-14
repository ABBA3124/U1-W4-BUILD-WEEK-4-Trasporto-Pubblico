package org.gestionetrasportopubblico.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity

public class Tessera {
    @Id
    @GeneratedValue
    private UUID numero_tessera;
    private LocalDate validita;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToMany(mappedBy = "tessera")
    private List<Abbonamento> abbonamenti;

    public Tessera() {
    }

    public Tessera(LocalDate validita) {
        this.validita = validita;
    }

    public UUID getNumero_tessera() {
        return numero_tessera;
    }

    public LocalDate getValidita() {
        return validita;
    }

    public void setValidita(LocalDate validita) {
        this.validita = validita;
    }

    public Utente getUtente() {
        return utente;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }


    @Override
    public String toString() {
        return "Tessera{" +
                "numero_tessera='" + numero_tessera + '\'' +
                ", validità=" + validita +


                '}';
    }
}
