package org.gestionetrasportopubblico;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.dao.UtenteDAO;
import org.gestionetrasportopubblico.entities.Utente;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public static void main(String[] args) {
        System.out.println("Start build week");

        UtenteDAO utenteDAO = new UtenteDAO();

        //crea utente
        Utente utente = new Utente();
        utente.setNome("nikita");
        utente.setCognome("Ivanov");
        utente.setNumeroTessera("12345678912");
        utente.setDataScadenzaTessera(LocalDate.now().plusYears(1));
        utenteDAO.create(utente);


        System.out.println(utente);


    }
}
