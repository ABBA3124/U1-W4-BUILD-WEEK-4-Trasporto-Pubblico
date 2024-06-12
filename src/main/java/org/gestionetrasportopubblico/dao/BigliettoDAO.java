package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Biglietto;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.util.List;

public class BigliettoDAO {

    private final EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Biglietto biglietto) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(biglietto);
            transaction.commit();
            System.out.println("---Il biglietto " + biglietto.getCodiceUnivoco() + " è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Biglietto findById(long id) {
        Biglietto biglietto = em.find(Biglietto.class, id);
        if (biglietto == null) {
            throw new NotFoundException(id);
        }
        return biglietto;
    }

    public void update(Biglietto biglietto) {
        em.getTransaction().begin();
        em.merge(biglietto);
        em.getTransaction().commit();
        System.out.println("---Il biglietto " + biglietto.getCodiceUnivoco() + " è stato aggiornato");
    }

    public List<Biglietto> findAll() {
        List<Biglietto> listaBiglietti = em.createQuery("SELECT b FROM Biglietto b", Biglietto.class).getResultList();
        return listaBiglietti;
    }

    public void deleteFromId(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Biglietto found = em.find(Biglietto.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---Il biglietto è stato eliminato");
            } else System.out.println("---Il biglietto non è stato trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
