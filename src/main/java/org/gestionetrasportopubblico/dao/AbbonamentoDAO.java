package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.gestionetrasportopubblico.entities.Abbonamento;
import org.gestionetrasportopubblico.entities.Utente;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class AbbonamentoDAO {

    private final EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Abbonamento abbonamento) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(abbonamento);
            transaction.commit();
            System.out.println("---L'abbonamento " + abbonamento.getCodiceUnivoco() + " è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Abbonamento findById(long id) {
        Abbonamento abbonamento = em.find(Abbonamento.class, id);
        if (abbonamento == null) {
            throw new NotFoundException(id);
        }
        return abbonamento;
    }

    public void update(Abbonamento abbonamento) {
        em.getTransaction().begin();
        em.merge(abbonamento);
        em.getTransaction().commit();
        System.out.println("---L'abbonamento " + abbonamento.getCodiceUnivoco() + " è stato aggiornato");
    }

    public List<Abbonamento> findAll() {
        List<Abbonamento> listaAbbonamenti = em.createQuery("SELECT a FROM Abbonamento a", Abbonamento.class).getResultList();
        return listaAbbonamenti;
    }

    public void deleteFromId(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Abbonamento found = em.find(Abbonamento.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---L'abbonamento è stato eliminato");
            } else System.out.println("---L'abbonamento non è stato trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Abbonamento> abbonamentoValiditaTessera(UUID id) {
        TypedQuery<Abbonamento> query = em.createQuery("SELECT a FROM Abbonamento a WHERE a.tessera.numero_tessera = :numero_tessera AND a.dataFine > :currentDate", Abbonamento.class);
        query.setParameter("numero_tessera", id);
        query.setParameter("currentDate", LocalDate.now());
        return query.getResultList();
    }

    public Abbonamento AbbonamentoPerUtente(String nomeUtente) {
        UtenteDAO ud = new UtenteDAO(em);
        Utente utenteFromDB = ud.findByName(nomeUtente);
        UUID idUtente = utenteFromDB.getId();
        TypedQuery<Abbonamento> query = em.createQuery("SELECT a FROM Abbonamento a WHERE a.utente.id = :idUtente", Abbonamento.class);
        query.setParameter("idUtente", idUtente);
        return query.getSingleResult();

    }


}
