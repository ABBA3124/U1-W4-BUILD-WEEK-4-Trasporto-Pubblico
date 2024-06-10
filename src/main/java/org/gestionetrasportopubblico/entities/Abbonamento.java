package org.gestionetrasportopubblico.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Abbonamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codiceUnivoco;
    private TipoAbbonamento tipo;
    private LocalDate dataInizio;
    private LocalDate dataFine;


    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


    public Abbonamento() {
    }

    public Abbonamento(String codiceUnivoco, TipoAbbonamento tipo, LocalDate dataInizio, LocalDate dataFine, Utente utente) {
        this.codiceUnivoco = codiceUnivoco;
        this.tipo = tipo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.utente = utente;
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "id=" + id +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", tipo=" + tipo +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", utente=" + utente +
                '}';
    }
}
