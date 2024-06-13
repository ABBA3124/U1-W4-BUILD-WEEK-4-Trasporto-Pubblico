package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.gestionetrasportopubblico.entities.Biglietto;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

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

    public List<Biglietto> validitaBiglietto() {
        TypedQuery<Biglietto> query = em.createQuery("SELECT t FROM Biglietto t WHERE t.convalidato = true", Biglietto.class);
        return query.getResultList();
    }

    public long bigliettiConvalidati(UUID id) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(vt) FROM Biglietto vt WHERE vt.convalidato = true AND vt.mezzo.id = :id", Long.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
