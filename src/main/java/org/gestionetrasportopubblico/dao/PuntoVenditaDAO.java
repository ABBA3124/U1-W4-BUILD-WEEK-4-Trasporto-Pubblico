package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.PuntoVendita;

import java.util.UUID;

public class PuntoVenditaDAO {

    private final EntityManager em;

    public PuntoVenditaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(PuntoVendita puntovendita) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(puntovendita);
            transaction.commit();
            System.out.println("---L'abbonamento " + puntovendita + "è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public PuntoVendita findById(UUID id) {
        PuntoVendita puntovendita = em.find(PuntoVendita.class, id);
        return puntovendita;
    }
}
