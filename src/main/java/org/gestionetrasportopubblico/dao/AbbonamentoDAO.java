package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Abbonamento;

import java.util.UUID;

public class AbbonamentoDAO {

    private final EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Abbonamento abbonamento) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(abbonamento);
            transaction.commit();
            System.out.println("---L'abbonamento " + abbonamento.getCodiceUnivoco() + "è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Abbonamento findById(UUID id) {
        Abbonamento abbonamento = em.find(Abbonamento.class, id);
        em.close();
        return abbonamento;
    }
}
