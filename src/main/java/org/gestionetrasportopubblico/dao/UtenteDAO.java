package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.entities.Utente;

import java.util.List;
import java.util.UUID;

public class UtenteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public void create(Utente utente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        em.close();
    }

    public Utente findById(UUID id) {
        EntityManager em = emf.createEntityManager();
        Utente utente = em.find(Utente.class, id);
        em.close();
        return utente;
    }

    public List<Utente> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Utente> utenti = em.createQuery("FROM Utente", Utente.class).getResultList();
        em.close();
        return utenti;
    }
}
