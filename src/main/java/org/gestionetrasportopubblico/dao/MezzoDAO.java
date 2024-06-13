package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.gestionetrasportopubblico.entities.Mezzo;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public class MezzoDAO {
    private final EntityManager em;

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public void createMezzo(Mezzo mezzo) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(mezzo);
            transaction.commit();
            System.out.println("---Il mezzo con id " + mezzo.getId() + " è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Mezzo findById(UUID id) {
        Mezzo mezzo = em.find(Mezzo.class, id);
        if (mezzo == null) {
            throw new NotFoundException(id);
        }
        return mezzo;
    }


    public void update(UUID id, Mezzo updatedMezzo) {
        // Trova la tratta tramite l'UUID fornito
        Mezzo mezzo = em.find(Mezzo.class, id);
        if (mezzo == null) {
            throw new NotFoundException(id); // Lancia eccezione se non trovata
        }

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // Aggiorna le proprietà della tratta esistente con i nuovi valori
            mezzo.setIn_servizio(updatedMezzo.isIn_servizio());
            mezzo.setIn_manutenzione(updatedMezzo.isIn_manutenzione());


            em.merge(mezzo); // Unisce l'entità modificata
            transaction.commit();
            System.out.println("Il mezzo è stato aggiornato con successo, id è rimasto invariato infatti è: " + mezzo.getId() + " Info Mezzo: " + "\n in servizio: " + mezzo.isIn_servizio() + "\nin manutenzione: " + mezzo.isIn_manutenzione());

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Esegui il rollback in caso di errore
            }
            throw e; // Rilancia l'eccezione
        }
    }


    public List<Mezzo> findAll() {
        List<Mezzo> listaMezzi = em.createQuery("SELECT m FROM Mezzo m", Mezzo.class).getResultList();
        return listaMezzi;
    }


    public void deleteFromId(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            Mezzo found = em.find(Mezzo.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---Il mezzo è stato eliminato");
            } else System.out.println("---Il mezzo non è stato trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Mezzo> mezziManutenzione() {
        TypedQuery<Mezzo> query = em.createQuery("SELECT v FROM Mezzo v WHERE v.in_manutenzione = true", Mezzo.class);
        return query.getResultList();
    }

}
