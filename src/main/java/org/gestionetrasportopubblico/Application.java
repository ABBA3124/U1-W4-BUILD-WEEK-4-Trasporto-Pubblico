package org.gestionetrasportopubblico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.dao.TesseraDAO;
import org.gestionetrasportopubblico.dao.UtenteDAO;
import org.gestionetrasportopubblico.entities.Tessera;

import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public static void main(String[] args) {
        System.out.println("Start build week");

        EntityManager em = emf.createEntityManager();
        UtenteDAO utenteDAO = new UtenteDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);

        //---------------------------------------------------------------------------------CREO TESSERA---------------------------------------------------------------------------------
//        Tessera tessera = new Tessera(LocalDate.now().plusYears(2));
//        tesseraDAO.create(tessera);
//        System.out.println(tessera);

        Tessera tesseraDB = tesseraDAO.findById(UUID.fromString("24833252-5223-4d1f-8d68-9dcb89e458c6"));

//---------------------------------------------------------------------------------CREO UTENTI---------------------------------------------------------------------------------
//        Utente utente = new Utente("Nikita", "Test", tesseraDB);
//        utenteDAO.create(utente);
//
//        System.out.println(utente);

//---------------------------------------------------------------------------------CERCO UTENTI CON UUID---------------------------------------------------------------------------------
//        Utente daTrovare = utenteDAO.findById(UUID.fromString("828028ab-16c2-4657-9e50-1f5ec8c55c5b"));
//        System.out.println("Utente trovato: " + daTrovare.getNome() + " " + daTrovare.getCognome());


//---------------------------------------------------------------------------------CERCO TUTTI GLI UTENTI---------------------------------------------------------------------------------
//        List<Utente> utenti = utenteDAO.findAll();
//        System.out.println("lista trovata");
//        for (Utente u : utenti) {
//            System.out.println(u.getNome() + " " + u.getCognome() + " " + u.getId());
//        }

//---------------------------------------------------------------------------------AGGIORNO UN UTENTE---------------------------------------------------------------------------------
//        Utente utenteDaAggiornare = utenteDAO.findById(UUID.fromString("cee86cb1-7644-4fe9-ad91-45bbabc7b12d"));
//        if (utenteDaAggiornare != null) {
//            utenteDaAggiornare.setNome("luca");
//            utenteDaAggiornare.setCognome("nardi");
//            utenteDAO.update(utenteDaAggiornare);
//            System.out.println(utenteDaAggiornare.getNome() + " " + utenteDaAggiornare.getCognome());
//
//        }

//---------------------------------------------------------------------------------ELIMINO UN UTENTE CON UUID---------------------------------------------------------------------------------
//        utenteDAO.delete(UUID.fromString("828028ab-16c2-4657-9e50-1f5ec8c55c5b"));
//
//        List<Utente> utenti2 = utenteDAO.findAll();
//        System.out.println("lista dopo eliminazioen");
//        for (Utente u : utenti2) {
//            System.out.println(u.getNome() + " " + u.getCognome() + " " + u.getId());
//        }
//---------------------------------------------------------------------------------Emissione Biglietti---------------------------------------------------------------------------------

    }
}
