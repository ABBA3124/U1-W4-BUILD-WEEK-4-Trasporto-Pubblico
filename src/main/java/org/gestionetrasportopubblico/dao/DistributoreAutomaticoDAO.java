package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.DistributoreAutomatico;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.util.List;

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
//            System.out.println("---Il distributore automatico " + distributoreautomatico.getId() + " è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DistributoreAutomatico findById(long id) {
        DistributoreAutomatico distributoreAutomatico = em.find(DistributoreAutomatico.class, id);
        if (distributoreAutomatico == null) {
            throw new NotFoundException(id);
        }
        return distributoreAutomatico;
    }


    public void update(long id, DistributoreAutomatico updatedDistributore) {
        // Trova il distributore tramite l'UUID fornito
        DistributoreAutomatico distributore = em.find(DistributoreAutomatico.class, id);
        if (distributore == null) {
            throw new NotFoundException(id); // Lancia eccezione se non trovata
        }

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // Aggiorna le proprietà della tratta esistente con i nuovi valori
            distributore.setAttivo(updatedDistributore.isAttivo());

            em.merge(distributore); // Unisce l'entità modificata
            transaction.commit();
            System.out.println("Il distributore è stato aggiornato con successo, id è rimasto invariato infatti è: " + distributore.getId() + " Info distributore: " + "\n Attivo: " + distributore.isAttivo());

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Esegui il rollback in caso di errore
            }
            throw e; // Rilancia l'eccezione
        }
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
