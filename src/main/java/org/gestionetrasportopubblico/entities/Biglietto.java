package org.gestionetrasportopubblico.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Biglietto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codiceUnivoco;
    private LocalDate dataEmissione;


    @ManyToOne
    @JoinColumn(name = "punto_vendita_id")
    private PuntoVendita puntoVendita;

    @ManyToOne
    @JoinColumn(name = "distributore_automatico_id")
    private DistributoreAutomatico distributoreAutomatico;

    public Biglietto() {
    }

    public Biglietto(String codiceUnivoco, LocalDate dataEmissione, PuntoVendita puntoVendita, DistributoreAutomatico distributoreAutomatico) {
        this.codiceUnivoco = codiceUnivoco;
        this.dataEmissione = dataEmissione;
        this.puntoVendita = puntoVendita;
        this.distributoreAutomatico = distributoreAutomatico;
    }

    public Long getId() {
        return id;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
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

    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + id +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", dataEmissione=" + dataEmissione +
                ", puntoVendita=" + puntoVendita +
                ", distributoreAutomatico=" + distributoreAutomatico +
                '}';
    }
}
