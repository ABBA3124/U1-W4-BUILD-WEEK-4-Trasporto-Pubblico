package org.gestionetrasportopubblico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.dao.*;
import org.gestionetrasportopubblico.entities.*;

import java.time.LocalDate;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public static <User> void main(String[] args) {
        System.out.println("Start build week");

        EntityManager em = emf.createEntityManager();
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em);
        BigliettoDAO bigliettoDAO = new BigliettoDAO(em);
        DistributoreAutomaticoDAO distributoreautomaticoDAO = new DistributoreAutomaticoDAO(em);
        MezzoDAO mezzoDAO = new MezzoDAO(em);
        PercorrenzaDAO percorrenzaDAO = new PercorrenzaDAO(em);
        PuntoVenditaDAO puntovenditaDAO = new PuntoVenditaDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        TrattaDAO trattaDAO = new TrattaDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);

        //---------------------------------------------------------------------------------CREO TESSERA---------------------------------------------------------------------------------
        Tessera tessera = new Tessera(LocalDate.now().plusYears(2));
        tesseraDAO.create(tessera);
//        System.out.println(tessera);

        //Tessera tesseraDB = tesseraDAO.findById(UUID.fromString("c446a62f-784d-46f6-9cbc-29f77b8a486e"));

//---------------------------------------------------------------------------------CREO UTENTI---------------------------------------------------------------------------------
        Utente utente = new Utente("Nikita", "Test", tessera);
        utenteDAO.create(utente);

//        System.out.println(utente);
        // Utente utenteDB = utenteDAO.findById(UUID.fromString("b44d01a3-db10-4231-8e2b-31fb50ef91af"));

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
//---------------------------------------------------------------------------------Distributore Automatico---------------------------------------------------------------------------------
        DistributoreAutomatico distributoreautomatico = new DistributoreAutomatico("Torino", true);
        distributoreautomaticoDAO.create(distributoreautomatico);

//---------------------------------------------------------------------------------Crea Biglietto------------------------------------------------------------------------------------------
        Mezzo mezzo_db = mezzoDAO.findById(UUID.fromString("8ea76113-3016-4a83-8c61-e799e4ea56d9"));
        Biglietto biglietto = new Biglietto(LocalDate.now().plusDays(7), true, null, distributoreautomatico, utente, mezzo_db);
        bigliettoDAO.create(biglietto);

//---------------------------------------------------------------------------------Crea Punto Vendita------------------------------------------------------------------------------------------
        PuntoVendita puntovendita = new PuntoVendita("Bar Uno", "Torino");
        puntovenditaDAO.create(puntovendita);

//---------------------------------------------------------------------------------Crea Abbonamento------------------------------------------------------------------------------------------
        Abbonamento abbonamento = new Abbonamento(TipoAbbonamento.MENSILE, LocalDate.now().minusDays(2), LocalDate.now().plusDays(5), null, null, null, null);
        abbonamentoDAO.create(abbonamento);
//        System.out.println(abbonamentoDAO.findAll());
//        abbonamentoDAO.deleteFromId(2);
//        System.out.println(abbonamentoDAO.findById(1));

//---------------------------------------------------------------------------------Creo Percorrenza------------------------------------------------------------------------------------------

        Percorrenza a1 = new Percorrenza(12.13);
        percorrenzaDAO.create(a1);
//        System.out.println(a1);
//
        Percorrenza a2 = new Percorrenza(25.17);
        percorrenzaDAO.create(a2);
//        System.out.println(a2);


//---------------------------------------------------------------------------------Creo mezzi------------------------------------------------------------------------------------------

        Tratta tratta1 = new Tratta("Messina", "Udine", 10);
        trattaDAO.create(tratta1);
        Mezzo autobus1 = new Autobus(true, false, bigliettoDAO.findAll(), 25, a1);
        mezzoDAO.createMezzo(autobus1);
//
        Mezzo tram1 = new Tram(true, false, bigliettoDAO.findAll(), 180, a2);
        mezzoDAO.createMezzo(tram1);

        System.out.println(bigliettoDAO.validitaBiglietto());
        System.out.println(bigliettoDAO.bigliettiConvalidati(UUID.fromString("8ea76113-3016-4a83-8c61-e799e4ea56d9")));
    }
}
