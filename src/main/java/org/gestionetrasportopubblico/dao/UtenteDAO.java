package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Utente;

import java.util.List;
import java.util.UUID;

public class UtenteDAO {

    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Utente utente) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(utente);
            transaction.commit();
            System.out.println("---L'utente " + utente.getNome() + utente.getCognome() + " è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Utente findById(UUID id) {
        Utente utente = em.find(Utente.class, id);
        return utente;
    }

    public List<Utente> findAll() {
        List<Utente> utenti = em.createQuery("FROM Utente", Utente.class).getResultList();
        return utenti;
    }

    public void update(Utente utente) {
        em.getTransaction().begin();
        em.merge(utente);
        em.getTransaction().commit();
        System.out.println("---L'utente " + utente.getNome() + utente.getCognome() + " è stato aggiornato");
    }

    public void deleteFromId(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            Utente found = em.find(Utente.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---L'utente è stato eliminato");
            } else System.out.println("---L'utente non è stato trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
