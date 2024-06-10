package org.gestionetrasportopubblico.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Biglietto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codiceUnivoco;
    private LocalDate dataEmissione;


    @ManyToOne
    @JoinColumn(name = "punto_vendita_id")
    private PuntoVendita puntoVendita;

    @ManyToOne
    @JoinColumn(name = "distributore_automatico_id")
    private DistributoreAutomatico distributoreAutomatico;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, PuntoVendita puntoVendita, DistributoreAutomatico distributoreAutomatico, Utente utente) {
        this.dataEmissione = dataEmissione;
        this.puntoVendita = puntoVendita;
        this.distributoreAutomatico = distributoreAutomatico;
        this.utente = utente;
    }

    public Long getCodiceUnivoco() {
        return codiceUnivoco;
    }


    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public PuntoVendita getPuntoVendita() {
        return puntoVendita;
    }

    public void setPuntoVendita(PuntoVendita puntoVendita) {
        this.puntoVendita = puntoVendita;
    }

    public DistributoreAutomatico getDistributoreAutomatico() {
        return distributoreAutomatico;
    }

    public void setDistributoreAutomatico(DistributoreAutomatico distributoreAutomatico) {
        this.distributoreAutomatico = distributoreAutomatico;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", dataEmissione=" + dataEmissione +
                ", puntoVendita=" + puntoVendita +
                ", distributoreAutomatico=" + distributoreAutomatico +
                ", utente=" + utente +
                '}';
    }
}
