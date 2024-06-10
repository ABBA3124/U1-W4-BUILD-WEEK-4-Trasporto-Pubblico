package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.Tessera;

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
            System.out.println("---La tessera " + tessera.getNumero_tessera() + "è stata salvata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Tessera findById(UUID id) {
        Tessera tessera = em.find(Tessera.class, id);
        return tessera;
    }

}
