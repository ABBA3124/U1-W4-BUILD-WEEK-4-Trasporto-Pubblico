package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Abbonamento;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.util.List;

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
            System.out.println("---L'abbonamento " + abbonamento.getCodiceUnivoco() + " è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Abbonamento findById(long id) {
        Abbonamento abbonamento = em.find(Abbonamento.class, id);
        if (abbonamento == null) {
            throw new NotFoundException(id);
        }
        return abbonamento;
    }

    public void update(Abbonamento abbonamento) {
        em.getTransaction().begin();
        em.merge(abbonamento);
        em.getTransaction().commit();
        System.out.println("---L'abbonamento " + abbonamento.getCodiceUnivoco() + " è stato aggiornato");
    }

    public List<Abbonamento> findAll() {
        List<Abbonamento> listaAbbonamenti = em.createQuery("SELECT a FROM Abbonamento a", Abbonamento.class).getResultList();
        return listaAbbonamenti;
    }

    public void deleteFromId(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Abbonamento found = em.find(Abbonamento.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---L'abbonamento è stato eliminato");
            } else System.out.println("---L'abbonamento non è stato trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
