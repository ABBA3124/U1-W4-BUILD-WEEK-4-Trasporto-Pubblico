package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Biglietto;

import java.util.List;
import java.util.UUID;

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
            System.out.println("---L'abbonamento " + biglietto + "è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Biglietto findById(UUID id) {
        Biglietto biglietto = em.find(Biglietto.class, id);
        return biglietto;
    }

    public List<Biglietto> findAll() {
        List<Biglietto> listaBiglietti = em.createQuery("SELECT b FROM Biglietto b", Biglietto.class).getResultList();
        return listaBiglietti;
    }
}
