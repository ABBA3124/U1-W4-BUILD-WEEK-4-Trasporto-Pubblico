package org.gestionetrasportopubblico;

import java.util.Scanner;

public class Application {
//    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public static <User> void main(String[] args) {
//        System.out.println("Start build week");

//        EntityManager em = emf.createEntityManager();
//        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em);
//        BigliettoDAO bigliettoDAO = new BigliettoDAO(em);
//        DistributoreAutomaticoDAO distributoreautomaticoDAO = new DistributoreAutomaticoDAO(em);
//        MezzoDAO mezzoDAO = new MezzoDAO(em);
//        PercorrenzaDAO percorrenzaDAO = new PercorrenzaDAO(em);
//        PuntoVenditaDAO puntovenditaDAO = new PuntoVenditaDAO(em);
//        TesseraDAO tesseraDAO = new TesseraDAO(em);
//        TrattaDAO trattaDAO = new TrattaDAO(em);
//        UtenteDAO utenteDAO = new UtenteDAO(em);
//
//        //---------------------------------------------------------------------------------CREO TESSERA---------------------------------------------------------------------------------
//        Tessera tessera = new Tessera(LocalDate.now().plusYears(1));
//        tesseraDAO.create(tessera);
////        System.out.println(tessera);
//
//        //Tessera tesseraDB = tesseraDAO.findById(UUID.fromString("c446a62f-784d-46f6-9cbc-29f77b8a486e"));
//
////---------------------------------------------------------------------------------CREO UTENTI---------------------------------------------------------------------------------
//        Utente utente = new Utente("Nikita", "Test", tessera);
//        utenteDAO.create(utente);
//
////        System.out.println(utente);
//        // Utente utenteDB = utenteDAO.findById(UUID.fromString("b44d01a3-db10-4231-8e2b-31fb50ef91af"));
//
////---------------------------------------------------------------------------------CERCO UTENTI CON UUID---------------------------------------------------------------------------------
////        Utente daTrovare = utenteDAO.findById(UUID.fromString("828028ab-16c2-4657-9e50-1f5ec8c55c5b"));
////        System.out.println("Utente trovato: " + daTrovare.getNome() + " " + daTrovare.getCognome());
//
//
////---------------------------------------------------------------------------------CERCO TUTTI GLI UTENTI---------------------------------------------------------------------------------
////        List<Utente> utenti = utenteDAO.findAll();
////        System.out.println("lista trovata");
////        for (Utente u : utenti) {
////            System.out.println(u.getNome() + " " + u.getCognome() + " " + u.getId());
////        }
//
////---------------------------------------------------------------------------------AGGIORNO UN UTENTE---------------------------------------------------------------------------------
////        Utente utenteDaAggiornare = utenteDAO.findById(UUID.fromString("cee86cb1-7644-4fe9-ad91-45bbabc7b12d"));
////        if (utenteDaAggiornare != null) {
////            utenteDaAggiornare.setNome("luca");
////            utenteDaAggiornare.setCognome("nardi");
////            utenteDAO.update(utenteDaAggiornare);
////            System.out.println(utenteDaAggiornare.getNome() + " " + utenteDaAggiornare.getCognome());
////
////        }
//
////---------------------------------------------------------------------------------ELIMINO UN UTENTE CON UUID---------------------------------------------------------------------------------
////        utenteDAO.delete(UUID.fromString("828028ab-16c2-4657-9e50-1f5ec8c55c5b"));
////
////        List<Utente> utenti2 = utenteDAO.findAll();
////        System.out.println("lista dopo eliminazioen");
////        for (Utente u : utenti2) {
////            System.out.println(u.getNome() + " " + u.getCognome() + " " + u.getId());
////        }
////---------------------------------------------------------------------------------Distributore Automatico---------------------------------------------------------------------------------
//        DistributoreAutomatico distributoreautomatico = new DistributoreAutomatico("Torino", true);
//        distributoreautomaticoDAO.create(distributoreautomatico);
//
////---------------------------------------------------------------------------------Crea Biglietto------------------------------------------------------------------------------------------
////        Mezzo mezzo_db = mezzoDAO.findById(UUID.fromString("373f51e4-48e7-4dd7-85a0-93599b6541b7"));
////        Biglietto biglietto = new Biglietto(LocalDate.now().plusDays(7), true, null, distributoreautomatico, utente, mezzo_db);
////        bigliettoDAO.create(biglietto);
//
////---------------------------------------------------------------------------------Crea Punto Vendita------------------------------------------------------------------------------------------
//        PuntoVendita puntovendita = new PuntoVendita("Bar Uno", "Torino");
//        puntovenditaDAO.create(puntovendita);
//
////---------------------------------------------------------------------------------Crea Abbonamento------------------------------------------------------------------------------------------
//        Abbonamento abbonamento = new Abbonamento(TipoAbbonamento.MENSILE, LocalDate.now().minusDays(2), LocalDate.now().plusDays(28), tessera, utente, puntovendita, null);
//        abbonamentoDAO.create(abbonamento);
////        System.out.println(abbonamentoDAO.findAll());
////        abbonamentoDAO.deleteFromId(2);
////        System.out.println(abbonamentoDAO.findById(1));
//
////---------------------------------------------------------------------------------Creo Percorrenza------------------------------------------------------------------------------------------
//
//        Percorrenza a1 = new Percorrenza(12.13);
//        percorrenzaDAO.create(a1);
////        System.out.println(a1);
////
//        Percorrenza a2 = new Percorrenza(25.17);
//        percorrenzaDAO.create(a2);
////        System.out.println(a2);
//
//
////---------------------------------------------------------------------------------Creo mezzi------------------------------------------------------------------------------------------
//
//        Tratta tratta1 = new Tratta("Messina", "Udine", 10);
//        trattaDAO.create(tratta1);
//        Mezzo autobus1 = new Autobus(true, false, bigliettoDAO.findAll(), 25, a1);
//        mezzoDAO.createMezzo(autobus1);
////
//        Mezzo tram1 = new Tram(true, false, bigliettoDAO.findAll(), 180, a2);
//        mezzoDAO.createMezzo(tram1);
//
//        System.out.println(bigliettoDAO.validitaBiglietto());
//        System.out.println(bigliettoDAO.bigliettiConvalidati(UUID.fromString("373f51e4-48e7-4dd7-85a0-93599b6541b7")));
//
////        System.out.println(abbonamentoDAO.abbonamentoValiditaTessera(UUID.fromString("795453c1-405c-48b1-851e-4cba0e0abc60")));


        //-------------------------------------------------------- Start Scanner --------------------------------------------------------
        Scanner sca = new Scanner(System.in);

        System.out.println("\n\tBenvenuto in Trasporti S.R.L.");

        System.out.println("\nseleziona modalità: ");
        System.out.println("Modalità Cliente: 1");
        System.out.println("Modalità Admin: 2");
        int x = sca.nextInt();
        int adminLogin = 1234;
        switch (x) {
            case 1:
                System.out.println("sei dentro cliente");
                //qui dentro tutto quello che può fare un cliente
                break;
            case 2:
                //qui dentro login per verificare se admin è autorizzato
                System.out.println("Inserisci Codice di sicurezza");
                int codice = sca.nextInt();
                if (codice == adminLogin) {
                    System.out.println("password corretta");
                    //qui dentro tutto quello che può fare un admin
                } else {
                    System.out.println("password non corretta");
                    //nota RICORDIAMOCI DI INSERIRLO NEL WHILE COSI RESTARTA
                }
                break;
            default:
                //nota RICORDIAMOCI DI INSERIRLO NEL WHILE COSI RESTARTA
                System.out.println("inserisci una modalità valida");

        }


    }
}
