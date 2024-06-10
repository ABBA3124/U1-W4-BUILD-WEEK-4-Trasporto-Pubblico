package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import org.gestionetrasportopubblico.entities.Utente;

public class UtenteDAO {

    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }


    public void create(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        em.close();

    }
}
