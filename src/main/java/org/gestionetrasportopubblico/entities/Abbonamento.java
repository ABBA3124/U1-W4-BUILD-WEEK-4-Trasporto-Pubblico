package org.gestionetrasportopubblico.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Abbonamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codiceUnivoco;
    @Enumerated(EnumType.STRING)
    private TipoAbbonamento tipo;
    private LocalDate dataInizio;
    private LocalDate dataFine;


    @ManyToOne
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "punto_vendita_id")
    private PuntoVendita puntoVendita;

    @ManyToOne
    @JoinColumn(name = "distributore_automatico_id")
    private DistributoreAutomatico distributoreAutomatico;

    public Abbonamento() {
    }

    public Abbonamento(TipoAbbonamento tipo, LocalDate dataInizio, LocalDate dataFine, Tessera tessera, Utente utente, PuntoVendita puntoVendita, DistributoreAutomatico distributoreAutomatico) {
        this.tipo = tipo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.tessera = tessera;
        this.utente = utente;
        this.puntoVendita = puntoVendita;
        this.distributoreAutomatico = distributoreAutomatico;
    }


    public Long getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public TipoAbbonamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAbbonamento tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
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
        return "Abbonamento{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", tipo=" + tipo +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", tessera=" + tessera +
                ", utente=" + utente +
                ", puntoVendita=" + puntoVendita +
                ", distributoreAutomatico=" + distributoreAutomatico +
                '}';
    }
}
