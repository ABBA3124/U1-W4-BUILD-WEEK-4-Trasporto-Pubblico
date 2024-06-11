package org.gestionetrasportopubblico.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mezzi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Mezzo {
    //Attributi
    @Id
    @GeneratedValue
    private UUID id;

    private boolean in_servizio;
    private boolean in_manutenzione;


    @OneToMany(mappedBy = "mezzo")
    private List<Biglietto> lista_biglietti;

    @ManyToMany
    @JoinTable(name = "percorrenza", joinColumns = @JoinColumn(name = "mezzo_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "tratta_id", nullable = false))
    private List<Tratta> lista_tratte;


    //costruttori
    public Mezzo() {
    }

    public Mezzo(boolean in_servizio, boolean in_manutenzione, List<Biglietto> lista_biglietti) {
        this.in_servizio = in_servizio;
        this.in_manutenzione = in_manutenzione;
        this.lista_biglietti = lista_biglietti;
    }

    //Metodi


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isIn_servizio() {
        return in_servizio;
    }

    public void setIn_servizio(boolean in_servizio) {
        this.in_servizio = in_servizio;
    }

    public boolean isIn_manutenzione() {
        return in_manutenzione;
    }

    public void setIn_manutenzione(boolean in_manutenzione) {
        this.in_manutenzione = in_manutenzione;
    }

    public List<Biglietto> getLista_biglietti() {
        return lista_biglietti;
    }

    public void setLista_biglietti(List<Biglietto> lista_biglietti) {
        this.lista_biglietti = lista_biglietti;
    }

    public List<Tratta> getLista_tratte() {
        return lista_tratte;
    }

    public void setLista_tratte(List<Tratta> lista_tratte) {
        this.lista_tratte = lista_tratte;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", in_servizio=" + in_servizio +
                ", in_manutenzione=" + in_manutenzione +
                ", lista_biglietti=" + lista_biglietti +
                '}';
    }

}
