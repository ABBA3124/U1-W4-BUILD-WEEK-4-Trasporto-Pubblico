package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Mezzo;

import java.util.UUID;

public class MezzoDAO {
    private final EntityManager em;

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public void createMezzo(Mezzo mezzo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mezzo);
        transaction.commit();
    }

    public Mezzo findById(UUID id) {
        Mezzo mezzo = em.find(Mezzo.class, id);
        return mezzo;
    }

    public void update(Mezzo mezzo) {
        em.getTransaction().begin();
        em.merge(mezzo);
        em.getTransaction().commit();
    }
}
