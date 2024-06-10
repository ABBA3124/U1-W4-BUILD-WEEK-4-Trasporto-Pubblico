package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.DistributoreAutomatico;

import java.util.UUID;

public class DistributoreAutomaticoDAO {

    private final EntityManager em;

    public DistributoreAutomaticoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(DistributoreAutomatico distributoreautomatico) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(distributoreautomatico);
            transaction.commit();
            System.out.println("---L'abbonamento " + distributoreautomatico + "è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DistributoreAutomatico findById(UUID id) {
        DistributoreAutomatico distributoreautomatico = em.find(DistributoreAutomatico.class, id);
        return distributoreautomatico;
    }
}
