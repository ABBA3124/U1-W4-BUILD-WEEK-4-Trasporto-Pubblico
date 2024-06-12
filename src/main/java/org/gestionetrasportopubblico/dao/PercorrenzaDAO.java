package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Percorrenza;

import java.util.List;
import java.util.UUID;

public class PercorrenzaDAO {


    private final EntityManager em;

    public PercorrenzaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Percorrenza percorrenza) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(percorrenza);
            transaction.commit();
            System.out.println("---La percorrenza " + percorrenza.getId() + " è stata salvata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Percorrenza findById(UUID id) {
        Percorrenza percorrenza = em.find(Percorrenza.class, id);
        return percorrenza;
    }

    public void update(Percorrenza percorrenza) {
        em.getTransaction().begin();
        em.merge(percorrenza);
        em.getTransaction().commit();
        System.out.println("---La percorrenza " + percorrenza.getId() + " è stata aggiornata");
    }

    public List<Percorrenza> findAll() {
        List<Percorrenza> listaPercorrenze = em.createQuery("SELECT p FROM Percorrenza p", Percorrenza.class).getResultList();
        return listaPercorrenze;
    }

    public void deleteFromId(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Percorrenza found = em.find(Percorrenza.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---La percorrenza è stata eliminata");
            } else System.out.println("---La percorrenza non è stata trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
