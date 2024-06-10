package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.entities.Utente;

public class UtenteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public void create(Utente utente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        em.close();
    }
}
