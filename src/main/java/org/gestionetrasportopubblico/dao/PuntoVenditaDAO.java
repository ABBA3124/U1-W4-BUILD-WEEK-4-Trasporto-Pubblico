package org.gestionetrasportopubblico.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.gestionetrasportopubblico.entities.PuntoVendita;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.util.List;

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
            System.out.println("---Il punto vendita " + puntovendita.getId() + "è stato salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public PuntoVendita findById(long id) {
        PuntoVendita puntoVendita = em.find(PuntoVendita.class, id);
        if (puntoVendita == null) {
            throw new NotFoundException(id);
        }
        return puntoVendita;
    }

    public void update(PuntoVendita puntoVendita) {
        em.getTransaction().begin();
        em.merge(puntoVendita);
        em.getTransaction().commit();
        System.out.println("---Il punto vendita " + puntoVendita.getId() + " è stato aggiornato");
    }

    public List<PuntoVendita> findAll() {
        List<PuntoVendita> listaPuntiVendita = em.createQuery("SELECT p FROM PuntoVendita p", PuntoVendita.class).getResultList();
        return listaPuntiVendita;
    }

    public void deleteFromId(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            PuntoVendita found = em.find(PuntoVendita.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("---Il punto di vendita è stato eliminato");
            } else System.out.println("---Il punto di vendita non è stato trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
