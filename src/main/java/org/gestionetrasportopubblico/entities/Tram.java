package org.gestionetrasportopubblico.entities;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Tram extends Mezzo {

    //Attributi
    private int capienza;

    //Costruttori

    public Tram() {
    }

    public Tram(boolean in_servizio, boolean in_manutenzione, List<Biglietto> lista_biglietti, int capienza, Percorrenza percorrenza) {
        super(in_servizio, in_manutenzione, lista_biglietti, percorrenza);
        this.capienza = capienza;
    }

    //Metodi


    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    @Override
    public String toString() {
        return "Tram{" +
                "capienza=" + capienza +
                '}';
    }
}
