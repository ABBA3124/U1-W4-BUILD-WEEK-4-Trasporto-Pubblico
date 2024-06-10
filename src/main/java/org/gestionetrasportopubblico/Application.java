package org.gestionetrasportopubblico;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.dao.UtenteDAO;
import org.gestionetrasportopubblico.entities.Utente;

import java.util.List;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public static void main(String[] args) {
        System.out.println("Start build week");

        UtenteDAO utenteDAO = new UtenteDAO();

//---------------------------------------------------------------------------------CREO UTENTI---------------------------------------------------------------------------------
//        Utente utente = new Utente();
//        utente.setNome("cdfsvfdv");
//        utente.setCognome("Ivfdvddfvdvfdfvdfv");
//        utente.setNumeroTessera("4646116514646651");
//        utente.setDataScadenzaTessera(LocalDate.now().plusYears(5));
//        utenteDAO.create(utente);

//        System.out.println(utente);

//---------------------------------------------------------------------------------CERCO UTENTI CON UUID---------------------------------------------------------------------------------
        Utente daTrovare = utenteDAO.findById(UUID.fromString("828028ab-16c2-4657-9e50-1f5ec8c55c5b"));
        System.out.println("Utente trovato: " + daTrovare.getNome() + " " + daTrovare.getCognome());


//---------------------------------------------------------------------------------CERCO TUTTI GLI UTENTI---------------------------------------------------------------------------------
        List<Utente> utenti = utenteDAO.findAll();
        System.out.println("lista trovata");
        for (Utente u : utenti) {
            System.out.println(u.getNome() + " " + u.getCognome());
        }
        
//---------------------------------------------------------------------------------CERCO TUTTI GLI UTENTI---------------------------------------------------------------------------------


    }
}
