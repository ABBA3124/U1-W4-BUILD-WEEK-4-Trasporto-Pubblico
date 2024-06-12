package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Tessera;

import java.util.List;
import java.util.UUID;

public class TesseraDAO {

    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Tessera tessera) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(tessera);
            transaction.commit();
            System.out.println("---La tessera numero " + tessera.getNumero_tessera() + " è stata salvata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Tessera findById(UUID id) {
        Tessera tessera = em.find(Tessera.class, id);
        return tessera;
    }

    public void update(Tessera tessera) {
        em.getTransaction().begin();
        em.merge(tessera);
        em.getTransaction().commit();
        System.out.println("---La tessera numero " + tessera.getNumero_tessera() + " è stata aggiornata");
    }

    public List<Tessera> findAll() {
        List<Tessera> listaTessere = em.createQuery("SELECT t FROM Tessera t", Tessera.class).getResultList();
        return listaTessere;
    }

    public void deleteFromId(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            Tessera found = em.find(Tessera.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---La tessera è stata eliminata");
            } else System.out.println("---La tessera non è stata trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
