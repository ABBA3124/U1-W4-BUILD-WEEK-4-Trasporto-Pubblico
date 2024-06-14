package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.gestionetrasportopubblico.entities.Tratta;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public class TrattaDAO {
    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Tratta tratta) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(tratta);
            transaction.commit();
            System.out.println("Tratta creata con successo, id assegnato è: " + tratta.getId() + "\n Info tratta: " + " Partenza: " + tratta.getZone_di_partenza() + " Capolinea: " + tratta.getCapolinea() + " Tempo mediamente impiegato: " + tratta.getTempo_medio());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Tratta findById(UUID id) {
        Tratta tratta = em.find(Tratta.class, id);
        if (tratta == null) {
            throw new NotFoundException(id);
        }
        return tratta;
    }

    public List<Tratta> findByZoneDiPartenza(String zoneDiPartenza) {
        String jpql = "SELECT t FROM Tratta t WHERE t.zone_di_partenza LIKE :zoneDiPartenza";
        TypedQuery<Tratta> query = em.createQuery(jpql, Tratta.class);
        query.setParameter("zoneDiPartenza", "%" + zoneDiPartenza + "%");
        return query.getResultList();
    }

    public List<Tratta> findByCapolinea(String capolinea) {
        String jpql = "SELECT t FROM Tratta t WHERE t.capolinea LIKE :capolinea";
        TypedQuery<Tratta> query = em.createQuery(jpql, Tratta.class);
        query.setParameter("capolinea", "%" + capolinea + "%");
        return query.getResultList();
    }


    public void update(UUID id, Tratta updatedTratta) {
        // Trova la tratta tramite l'UUID fornito
        Tratta tratta = em.find(Tratta.class, id);
        if (tratta == null) {
            throw new NotFoundException(id); // Lancia eccezione se non trovata
        }

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // Aggiorna le proprietà della tratta esistente con i nuovi valori
            tratta.setZone_di_partenza(updatedTratta.getZone_di_partenza());
            tratta.setCapolinea(updatedTratta.getCapolinea());
            tratta.setTempo_medio(updatedTratta.getTempo_medio());

            em.merge(tratta); // Unisce l'entità modificata
            transaction.commit();
            System.out.println("Tratta aggiornata con successo, id è rimasto invariato infatti è: " + tratta.getId() + "\n Riepilogo tratta: " + " -Partenza: " + tratta.getZone_di_partenza() + " -Capolinea: " + tratta.getCapolinea() + " Tempo mediamente impiegato: " + tratta.getTempo_medio());

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Esegui il rollback in caso di errore
            }
            throw e; // Rilancia l'eccezione
        }
    }


    public List<Tratta> findAll() {
        List<Tratta> listaTratte = em.createQuery("SELECT t FROM Tratta t", Tratta.class).getResultList();
        return listaTratte;
    }

    public void deleteFromId(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            Tratta found = em.find(Tratta.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---La tratta è stata eliminata");
            } else System.out.println("---La tratta non è stata trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
