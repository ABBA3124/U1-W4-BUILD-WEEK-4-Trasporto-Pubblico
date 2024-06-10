package org.gestionetrasportopubblico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.dao.UtenteDAO;
import org.gestionetrasportopubblico.entities.Utente;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public static void main(String[] args) {
        System.out.println("Start build week");

        EntityManager em = emf.createEntityManager();
        UtenteDAO utenteDAO = new UtenteDAO(em);
        Utente utente = new Utente();
        utente.setNome("luca");
        utente.setCognome("nardi");
        utente.setNumeroTessera("123456789");
        utente.setDataScadenzaTessera(LocalDate.now().plusYears(1));

        utenteDAO.create(utente);

        System.out.println(utente + " creato? ");

    }
}
