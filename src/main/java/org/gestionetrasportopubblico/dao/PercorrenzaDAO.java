package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Percorrenza;

import java.util.UUID;

public class PercorrenzaDAO {


    private final EntityManager em;

    public PercorrenzaDAO(EntityManager em) {
        this.em = em;
    }

    public void creaPercorrenza(Percorrenza percorrenza) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(percorrenza);
        transaction.commit();
    }

    public Percorrenza findByIdPercorrenza(UUID id) {
        Percorrenza percorrenza = em.find(Percorrenza.class, id);
        return percorrenza;
    }

    public void updatePercorrenza(Percorrenza percorrenza) {
        em.getTransaction().begin();
        em.merge(percorrenza);
        em.getTransaction().commit();
    }
}
