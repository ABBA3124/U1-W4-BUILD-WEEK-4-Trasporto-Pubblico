package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.DistributoreAutomatico;

import java.util.List;
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
            System.out.println("---Il distributore automatico " + distributoreautomatico.getId() + " è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DistributoreAutomatico findById(UUID id) {
        DistributoreAutomatico distributoreautomatico = em.find(DistributoreAutomatico.class, id);
        return distributoreautomatico;
    }

    public void update(DistributoreAutomatico distributoreAutomatico) {
        em.getTransaction().begin();
        em.merge(distributoreAutomatico);
        em.getTransaction().commit();
        System.out.println("---Il distributore automatico " + distributoreAutomatico.getId() + " è stato aggiornato");
    }

    public List<DistributoreAutomatico> findAll() {
        List<DistributoreAutomatico> listaDistributori = em.createQuery("SELECT d FROM DistributoreAutomatico d", DistributoreAutomatico.class).getResultList();
        return listaDistributori;
    }

    public void deleteFromId(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            DistributoreAutomatico found = em.find(DistributoreAutomatico.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---Il distributore automatico è stato eliminato");
            } else System.out.println("---Il distributore automatico non è stato trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
