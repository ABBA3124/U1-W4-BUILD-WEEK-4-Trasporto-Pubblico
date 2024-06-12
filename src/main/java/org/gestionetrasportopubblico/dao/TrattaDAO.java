package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Tratta;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public class TrattaDAO {
    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Tratta tratta) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(tratta);
            transaction.commit();
            System.out.println("---La tratta " + tratta.getId() + " è stata salvata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Tratta findById(UUID id) {
        Tratta tratta = em.find(Tratta.class, id);
        if (tratta == null) {
            throw new NotFoundException(id);
        }
        return tratta;
    }

    public void update(Tratta tratta) {
        em.getTransaction().begin();
        em.merge(tratta);
        em.getTransaction().commit();
        System.out.println("---La tratta " + tratta.getId() + " è stata aggiornata");
    }

    public List<Tratta> findAll() {
        List<Tratta> listaTratte = em.createQuery("SELECT t FROM Tratta t", Tratta.class).getResultList();
        return listaTratte;
    }

    public void deleteFromId(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            Tratta found = em.find(Tratta.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---La tratta è stata eliminata");
            } else System.out.println("---La tratta non è stata trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
