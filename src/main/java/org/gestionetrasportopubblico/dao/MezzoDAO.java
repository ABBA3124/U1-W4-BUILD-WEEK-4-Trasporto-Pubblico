package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Mezzo;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public class MezzoDAO {
    private final EntityManager em;

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public void createMezzo(Mezzo mezzo) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(mezzo);
            transaction.commit();
            System.out.println("---Il mezzo con id " + mezzo.getId() + " è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Mezzo findById(UUID id) {
        Mezzo mezzo = em.find(Mezzo.class, id);
        if (mezzo == null) {
            throw new NotFoundException(id);
        }
        return mezzo;
    }

    public void update(Mezzo mezzo) {
        em.getTransaction().begin();
        em.merge(mezzo);
        em.getTransaction().commit();
        System.out.println("---Il mezzo " + mezzo.getId() + " è stato aggiornato");
    }

    public List<Mezzo> findAll() {
        List<Mezzo> listaMezzi = em.createQuery("SELECT m FROM Mezzo m", Mezzo.class).getResultList();
        return listaMezzi;
    }

    public void deleteFromId(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            Mezzo found = em.find(Mezzo.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---Il mezzo è stato eliminato");
            } else System.out.println("---Il mezzo non è stato trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
