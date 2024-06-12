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

    @ManyToOne
    @JoinColumn(name = "percorrenza_id")
    private Percorrenza percorrenza;


    @OneToMany(mappedBy = "mezzo")
    private List<Biglietto> lista_biglietti;


    //costruttori
    public Mezzo() {
    }

    public Mezzo(boolean in_servizio, boolean in_manutenzione, List<Biglietto> lista_biglietti, Percorrenza percorrenza) {
        this.in_servizio = in_servizio;
        this.in_manutenzione = in_manutenzione;
        this.lista_biglietti = lista_biglietti;
        this.percorrenza = percorrenza;
    }

    public UUID getId() {
        return id;
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

    public Percorrenza getPercorrenza() {
        return percorrenza;
    }


    public List<Biglietto> getLista_biglietti() {
        return lista_biglietti;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", in_servizio=" + in_servizio +
                ", in_manutenzione=" + in_manutenzione +
                ", percorrenza=" + percorrenza +
                ", lista_biglietti=" + lista_biglietti +
                '}';
    }
}
