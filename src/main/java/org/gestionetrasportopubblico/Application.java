package org.gestionetrasportopubblico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.dao.*;
import org.gestionetrasportopubblico.entities.*;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public static <User> void main(String[] args) {
//        System.out.println("Start build week");

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
        Scanner sca = new Scanner(System.in);


        System.out.println("---- DB PRONTO ----");

        System.out.println("Popolo il db ? (true or false) ");

        boolean fbdvjkh = sca.nextBoolean();
        //boolean fbdvjkh = false;

        if (fbdvjkh == true) {
            System.out.println("hai selezionato " + fbdvjkh);
            //------------------------------------------------------------- TESSERA -------------------------------------------------------------
            Tessera tessera1 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera1);

            Tessera tessera2 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera2);

            Tessera tessera3 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera3);

            Tessera tessera4 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera4);

            Tessera tessera5 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera5);

            Tessera tessera6 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera6);

            Tessera tessera7 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera7);

            Tessera tessera8 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera8);

            Tessera tessera9 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera9);

            Tessera tessera10 = new Tessera(LocalDate.now().plusYears(1));
            tesseraDAO.create(tessera10);


            //------------------------------------------------------------- UTENTI -------------------------------------------------------------
            Utente utente1 = new Utente("Davide", "Abbadessa", tessera1);
            utenteDAO.create(utente1);

            Utente utente2 = new Utente("Nikita", "Ivanov", tessera2);
            utenteDAO.create(utente2);

            Utente utente3 = new Utente("Emanuele", "Pezzato", tessera3);
            utenteDAO.create(utente3);

            Utente utente4 = new Utente("Luca", "Nardi", tessera4);
            utenteDAO.create(utente4);

            Utente utente5 = new Utente("Riccardo", "Gulin", tessera5);
            utenteDAO.create(utente5);


            //------------------------------------------------------------- DISTRIBUTORE AUTOMATICO -------------------------------------------------------------
            DistributoreAutomatico distributoreautomatico1 = new DistributoreAutomatico("Torino", true);
            distributoreautomaticoDAO.create(distributoreautomatico1);

            DistributoreAutomatico distributoreautomatico2 = new DistributoreAutomatico("Milano", true);
            distributoreautomaticoDAO.create(distributoreautomatico2);

            DistributoreAutomatico distributoreautomatico3 = new DistributoreAutomatico("Roma", true);
            distributoreautomaticoDAO.create(distributoreautomatico3);

            DistributoreAutomatico distributoreautomatico4 = new DistributoreAutomatico("Messina", true);
            distributoreautomaticoDAO.create(distributoreautomatico4);

            DistributoreAutomatico distributoreautomatico5 = new DistributoreAutomatico("Napoli", true);
            distributoreautomaticoDAO.create(distributoreautomatico5);


            //------------------------------------------------------------- PERCORRENZA -------------------------------------------------------------

            Percorrenza percorrenza1 = new Percorrenza(12.13);
            percorrenzaDAO.create(percorrenza1);


            Percorrenza percorrenza2 = new Percorrenza(25.17);
            percorrenzaDAO.create(percorrenza2);


            Percorrenza percorrenza3 = new Percorrenza(45.12);
            percorrenzaDAO.create(percorrenza3);


            Percorrenza percorrenza4 = new Percorrenza(2.17);
            percorrenzaDAO.create(percorrenza4);


            Percorrenza percorrenza5 = new Percorrenza(5.17);
            percorrenzaDAO.create(percorrenza5);


            Percorrenza percorrenza6 = new Percorrenza(24.17);
            percorrenzaDAO.create(percorrenza6);


            Percorrenza percorrenza7 = new Percorrenza(1.17);
            percorrenzaDAO.create(percorrenza7);


            Percorrenza percorrenza8 = new Percorrenza(3.57);
            percorrenzaDAO.create(percorrenza8);


            Percorrenza percorrenza9 = new Percorrenza(4.41);
            percorrenzaDAO.create(percorrenza9);

            Percorrenza percorrenza10 = new Percorrenza(2.29);
            percorrenzaDAO.create(percorrenza10);


            //------------------------------------------------------------- TRATTE -------------------------------------------------------------

            Tratta tratta1 = new Tratta("Messina", "Udine", 10);
            trattaDAO.create(tratta1);

            Tratta tratta2 = new Tratta("Milano", "Roma", 4.20);
            trattaDAO.create(tratta2);

            Tratta tratta3 = new Tratta("Roma", "Milano", 4.20);
            trattaDAO.create(tratta3);

            Tratta tratta4 = new Tratta("Patti", "Palermo", 3.26);
            trattaDAO.create(tratta4);

            Tratta tratta5 = new Tratta("Palermo", "Patti", 3.26);
            trattaDAO.create(tratta5);

            Tratta tratta6 = new Tratta("Genova", "Torino", 2.31);
            trattaDAO.create(tratta6);

            Tratta tratta7 = new Tratta("Torino", "Genova", 2.31);
            trattaDAO.create(tratta7);

            Tratta tratta8 = new Tratta("Messina", "Catania", 2.51);
            trattaDAO.create(tratta8);

            Tratta tratta9 = new Tratta("Palermo", "Catania", 3.56);
            trattaDAO.create(tratta9);

            Tratta tratta10 = new Tratta("Catania", "Roma", 9.51);
            trattaDAO.create(tratta10);

            Tratta tratta11 = new Tratta("Napoli", "Roma", 6.47);
            trattaDAO.create(tratta11);

            //------------------------------------------------------------- MEZZI -------------------------------------------------------------

            //-----CREO AUTOBUS ----
            Mezzo autobus1 = new Autobus(true, false, bigliettoDAO.findAll(), 25, percorrenza1);
            mezzoDAO.createMezzo(autobus1);

            Mezzo autobus2 = new Autobus(true, false, bigliettoDAO.findAll(), 25, percorrenza2);
            mezzoDAO.createMezzo(autobus2);

            Mezzo autobus3 = new Autobus(true, false, bigliettoDAO.findAll(), 25, percorrenza3);
            mezzoDAO.createMezzo(autobus3);

            Mezzo autobus4 = new Autobus(true, false, bigliettoDAO.findAll(), 25, percorrenza4);
            mezzoDAO.createMezzo(autobus4);

            Mezzo autobus5 = new Autobus(true, false, bigliettoDAO.findAll(), 25, percorrenza5);
            mezzoDAO.createMezzo(autobus5);


            //-----CREO TRAM ----
            Mezzo tram1 = new Tram(true, false, bigliettoDAO.findAll(), 180, percorrenza6);
            mezzoDAO.createMezzo(tram1);

            Mezzo tram2 = new Tram(true, false, bigliettoDAO.findAll(), 180, percorrenza7);
            mezzoDAO.createMezzo(tram2);

            Mezzo tram3 = new Tram(true, false, bigliettoDAO.findAll(), 180, percorrenza8);
            mezzoDAO.createMezzo(tram3);

            Mezzo tram4 = new Tram(true, false, bigliettoDAO.findAll(), 180, percorrenza9);
            mezzoDAO.createMezzo(tram4);

            Mezzo tram5 = new Tram(true, false, bigliettoDAO.findAll(), 180, percorrenza10);
            mezzoDAO.createMezzo(tram5);


            //------------------------------------------------------------- BIGLIETTO -------------------------------------------------------------


            Biglietto biglietto1 = new Biglietto(LocalDate.now().plusDays(7), true, null, distributoreautomatico1, utente1, autobus1);
            bigliettoDAO.create(biglietto1);

            Biglietto biglietto2 = new Biglietto(LocalDate.now().plusDays(7), true, null, distributoreautomatico2, utente2, autobus2);
            bigliettoDAO.create(biglietto2);

            Biglietto biglietto3 = new Biglietto(LocalDate.now().plusDays(7), true, null, distributoreautomatico3, utente3, autobus3);
            bigliettoDAO.create(biglietto3);

            Biglietto biglietto4 = new Biglietto(LocalDate.now().plusDays(7), true, null, distributoreautomatico4, utente4, tram1);
            bigliettoDAO.create(biglietto4);

            Biglietto biglietto5 = new Biglietto(LocalDate.now().plusDays(7), true, null, distributoreautomatico5, utente5, tram2);
            bigliettoDAO.create(biglietto5);


            //------------------------------------------------------------- PUNTO VENDITA -------------------------------------------------------------
            PuntoVendita puntovendita1 = new PuntoVendita("Bar Uno", "Torino");
            puntovenditaDAO.create(puntovendita1);

            PuntoVendita puntovendita2 = new PuntoVendita("Bar due", "Milano");
            puntovenditaDAO.create(puntovendita2);

            PuntoVendita puntovendita3 = new PuntoVendita("Bar tre", "Catania");
            puntovenditaDAO.create(puntovendita3);

            PuntoVendita puntovendita4 = new PuntoVendita("Bar quattro", "Patti");
            puntovenditaDAO.create(puntovendita4);

            PuntoVendita puntovendita5 = new PuntoVendita("Bar cinque", "Roma");
            puntovenditaDAO.create(puntovendita5);


            //------------------------------------------------------------- ABBONAMENTO -------------------------------------------------------------
            Abbonamento abbonamento1 = new Abbonamento(TipoAbbonamento.MENSILE, LocalDate.now().minusDays(2), LocalDate.now().plusDays(28), tessera1, utente1, puntovendita1, distributoreautomatico1);
            abbonamentoDAO.create(abbonamento1);

            Abbonamento abbonamento2 = new Abbonamento(TipoAbbonamento.MENSILE, LocalDate.now().minusDays(2), LocalDate.now().plusDays(28), tessera2, utente2, puntovendita2, distributoreautomatico2);
            abbonamentoDAO.create(abbonamento2);

            Abbonamento abbonamento3 = new Abbonamento(TipoAbbonamento.MENSILE, LocalDate.now().minusDays(2), LocalDate.now().plusDays(28), tessera3, utente3, puntovendita3, distributoreautomatico3);
            abbonamentoDAO.create(abbonamento3);

            Abbonamento abbonamento4 = new Abbonamento(TipoAbbonamento.MENSILE, LocalDate.now().minusDays(2), LocalDate.now().plusDays(28), tessera4, utente4, puntovendita4, distributoreautomatico4);
            abbonamentoDAO.create(abbonamento4);

            Abbonamento abbonamento5 = new Abbonamento(TipoAbbonamento.MENSILE, LocalDate.now().minusDays(2), LocalDate.now().plusDays(28), tessera5, utente5, puntovendita1, distributoreautomatico5);
            abbonamentoDAO.create(abbonamento5);


            System.out.println("DB POPOLATO ? " + fbdvjkh);
        } else {
            System.out.println("DB POPOLATO? " + fbdvjkh);
        }


        //-------------------------------------------------------- Start Scanner --------------------------------------------------------


//        Mezzo autobus1 = new Autobus(true, false, bigliettoDAO.findAll(), 25, null);
//        mezzoDAO.createMezzo(autobus1);

        // Mezzo mezzo = mezzoDAO.findById(UUID.fromString("0a718917-01fc-425d-905e-f58e7a99e098"));


//        Biglietto biglietto1 = new Biglietto(LocalDate.now().plusDays(2), true, null, distributoreautomaticoDAO.findById(2), utenteDAO.findByName("Giacomo"), mezzo);
//        bigliettoDAO.create(biglietto1);

        System.out.println("\n\t🚌Benvenuto in Trasporti🚃 S.R.L.");

        System.out.println("\nSeleziona Modalità: ");
        System.out.println("\n🙋Sei un Cliente? digita --> 1️⃣");
        System.out.println("⚙️Modalità Admin🔧 --> 2️⃣");
        System.out.println("⬇️");
        int x = sca.nextInt();

        switch (x) {
            //USER CASE
            case 1:
                System.out.println("🙋sei dentro cliente🙋");
                //qui dentro tutto quello che può fare un cliente

                System.out.println("Visualizza Info Utente --> 1️⃣");
                System.out.println("Comprare Biglietto/Abbonamento --> 2️⃣");

                int sceltaUtente = sca.nextInt();
                switch (sceltaUtente) {
                    case 1:
                        System.out.println("Info Utente");
                        System.out.println("Visualizza Utente --> 1️⃣");
                        System.out.println("Visualizza info Biglietto--> 2️⃣");
                        System.out.println("Visualizza Info Abbonamento --> 3️⃣");
                        System.out.println("Visualizza Tratta --> 4️⃣");
                        int infoUtente = sca.nextInt();
                        sca.nextLine();
                        switch (infoUtente) {
                            case 1:
                                System.out.println("Inserisci il tuo nome:");
                                String nomeUtente = sca.nextLine();
                                System.out.println(utenteDAO.findByName(nomeUtente));
                                break;
                            case 2:
                                System.out.println("Inserisci il tuo nome:");
                                nomeUtente = sca.nextLine();
                                bigliettoDAO.bigliettiPerUtente(nomeUtente).stream().forEach(System.out::println);

                                break;
                            case 3:
                                System.out.println("Inserisci il tuo nome:");
                                nomeUtente = sca.nextLine();
                                System.out.println(abbonamentoDAO.AbbonamentoPerUtente(nomeUtente));


                            default:
                                break;
                        }
                }


                break;
            case 2:
                //qui dentro login per verificare se admin è autorizzato
                Admin fs0224 = new Admin("Davide", "Abbadessa");
                System.out.println("🔐Inserisci Codice di sicurezza🔐");
                int codice = sca.nextInt();
                if (codice == fs0224.getCodice()) {
                    System.out.println("🔓Password Corretta🔓");
                    //qui dentro tutto quello che può fare un admin

                    //Lista di cose selezionabili
                    System.out.println(fs0224);
                    System.out.println("\n<-- ⚙️Admin Menu🔧 -->");
                    System.out.println("Tratta --> 1️⃣"); //TUTTO OK COMPLETATO✔️
                    System.out.println("Mezzo --> 2️⃣"); //TUTTO OK COMPLETATO✔️
                    System.out.println("Distributori --> 3️⃣");
                    System.out.println("Punti vendita --> 4️⃣");

                    //sarà la decisione del admin
                    int dentroAdmin = sca.nextInt();

                    switch (dentroAdmin) {
                        case 1:
                            System.out.println("\n<-- Modale Tratta -->");
                            System.out.println("Visualizza Tratte --> 1️⃣");
                            System.out.println("Crea Tratta --> 2️⃣");
                            System.out.println("Modificare Tratta --> 3️⃣");
                            System.out.println("Elimina Tratta --> 4️⃣");
                            System.out.println("Cerca Tratta per Capolinea --> 5️⃣");
                            System.out.println("Cerca Tratta per Partenza --> 6️⃣");
                            int tratta = sca.nextInt();
                            sca.nextLine();

                            switch (tratta) {
                                case 1:
                                    //visualizzazione tutte le tratte
                                    System.out.println("Elenco di tutte le tratte: ");
                                    trattaDAO.findAll().stream().forEach(System.out::println);

                                    break;
                                case 2:
                                    //Stiamo istanziando una tratta nuova
                                    Tratta trattaCheStaCreandoLutenteInQuestoMomento = new Tratta();

                                    System.out.println("Inserisci la Zona di partenza.");
                                    String quelloCheInserisce1 = sca.nextLine();
                                    trattaCheStaCreandoLutenteInQuestoMomento.setZone_di_partenza(quelloCheInserisce1);


                                    System.out.println("Inserisci un Capolinea.");
                                    String quelloCheInserisce3 = sca.nextLine();
                                    trattaCheStaCreandoLutenteInQuestoMomento.setCapolinea(quelloCheInserisce3);

                                    System.out.println("Inserisci il Tempo della Tratta h/m");
                                    double quelloCheInserisce2 = sca.nextDouble();
                                    trattaCheStaCreandoLutenteInQuestoMomento.setTempo_medio(quelloCheInserisce2);

                                    //salvataggio nel db
                                    trattaDAO.create(trattaCheStaCreandoLutenteInQuestoMomento);


                                    break;
                                case 3:
                                    // modifica tratta tramite id

                                    System.out.println("Elenco di tutte le tratte: ");
                                    trattaDAO.findAll().stream().forEach(System.out::println);

                                    System.out.println("Inserisci l'ID della tratta da aggiornare:");
                                    String idInseritoDaUtente = sca.nextLine();
                                    UUID id = UUID.fromString(idInseritoDaUtente);

                                    Tratta trattaCheStaModificandoLutenteInQuestoMomento = new Tratta();

                                    System.out.println("Inserisci la nuova Zona di partenza.");
                                    String quelloCheInserisce4 = sca.nextLine();
                                    trattaCheStaModificandoLutenteInQuestoMomento.setZone_di_partenza(quelloCheInserisce4);

                                    System.out.println("Inserisci un nuovo Capolinea.");
                                    String quelloCheInserisce5 = sca.nextLine();
                                    trattaCheStaModificandoLutenteInQuestoMomento.setCapolinea(quelloCheInserisce5);

                                    System.out.println("Inserisci il nuovo Tempo della Tratta h/m");
                                    double quelloCheInserisce6 = sca.nextDouble();
                                    trattaCheStaModificandoLutenteInQuestoMomento.setTempo_medio(quelloCheInserisce6);

                                    try {
                                        //salvataggio nel db
                                        trattaDAO.update(id, trattaCheStaModificandoLutenteInQuestoMomento);

                                    } catch (NotFoundException e) {
                                        System.err.println(e.getMessage());
                                    }

                                    break;
                                case 4:
                                    // elimina tratta in base id
                                    System.out.println("Elenco di tutte le tratte: ");
                                    trattaDAO.findAll().stream().forEach(System.out::println);

                                    String idDeleteDatoUtente = sca.nextLine();

                                    trattaDAO.deleteFromId(UUID.fromString(idDeleteDatoUtente));


                                    break;
                                case 5:
                                    //Caso 5 cerchiamo per Capoline
                                    System.out.println("Inserisci il capolinea da cercare:");
                                    String cercaPerCapolinea = sca.nextLine();

                                    List<Tratta> tratte = trattaDAO.findByCapolinea(cercaPerCapolinea);
                                    tratte.forEach(System.out::println);
                                    break;
                                case 6:
                                    // Caso 5 cerchiamo per Partenza
                                    System.out.println("Inserisci il capolinea da cercare:");
                                    String cercaPerZoneDiPartenza = sca.nextLine();

                                    List<Tratta> tratte2 = trattaDAO.findByZoneDiPartenza(cercaPerZoneDiPartenza);
                                    tratte2.forEach(System.out::println);
                                    break;
                                default:
                                    System.out.println(tratta + " ❌ " + " Inserisci un numero valido.");
                            }


                            break;
                        case 2:
                            //ENTRIAMO DENTRO MEZZO QUIIIII
                            System.out.println("\n<-- Modale Mezzi -->");
                            System.out.println("Visualizza Tutti i Mezzi --> 1️⃣");
                            System.out.println("Crea Mezzo --> 2️⃣");
                            System.out.println("Modificare Mezzo --> 3️⃣");
                            System.out.println("Elimina Mezzo --> 4️⃣");
                            System.out.println("Visualizza Mezzi in Manutenzione --> 5️⃣");


                            int quelloCheInserisceAdminInModaleMezzi = sca.nextInt();
                            sca.nextLine();

                            switch (quelloCheInserisceAdminInModaleMezzi) {
                                case 1:
                                    //findall
                                    System.out.println("Elenco di tutti i Mezzi: ");
                                    mezzoDAO.findAll().stream().forEach(System.out::println);

                                    break;
                                case 2:

                                    //crea mezzo (doppio menu)
                                    System.out.println("\nSeleziona il mezzo da creare.");
                                    System.out.println("Autobus --> 1");
                                    System.out.println("Tram --> 2");

                                    int cheMezzoVuoiCreare = sca.nextInt();

                                    switch (cheMezzoVuoiCreare) {
                                        case 1:
                                            //crea autobus
                                            System.out.println("\n<-- Creazione Autobus Menu -->");

                                            System.out.println("Inserisci Capienza");
                                            int capienzaAutobus = sca.nextInt();
                                            Mezzo autobus = new Autobus(true, false, null, capienzaAutobus, null);
                                            mezzoDAO.createMezzo(autobus);

                                            break;
                                        case 2:
                                            //crea tram

                                            System.out.println("\n<-- Creazione Tram Menu -->");

                                            System.out.println("Inserisci Capienza");
                                            int capienzaTram = sca.nextInt();
                                            Mezzo tram1 = new Tram(true, false, null, capienzaTram, null);
                                            mezzoDAO.createMezzo(tram1);


                                            break;


                                        default:
                                            System.out.println(cheMezzoVuoiCreare + " ❌ " + " Inserisci un numero valido.");
                                    }


                                    break;
                                case 3:
                                    //modifica update mezzo

                                    System.out.println("\nSeleziona il mezzo che vuoi modificare");

                                    System.out.println("Autobus --> 1");
                                    System.out.println("Tram --> 2");

                                    int dioPorco = sca.nextInt();

                                    switch (dioPorco) {
                                        case 1:

                                            System.out.println("Elenco di tutti i mezzi: ");
                                            mezzoDAO.findAll().stream().forEach(System.out::println);
                                            sca.nextLine();

                                            System.out.println("\nInserisci l'ID dell' Autobus da Aggiornare:");
                                            String idInseritoMezzo = sca.nextLine();
                                            UUID id = UUID.fromString(idInseritoMezzo);

                                            Mezzo MezzoCheStaModificandoLutenteInQuestoMomento = new Autobus();

                                            System.out.println("il mezzo è in servizio ? (true or false)");
                                            Boolean quelloCheInserisce10 = sca.nextBoolean();
                                            MezzoCheStaModificandoLutenteInQuestoMomento.setIn_servizio(quelloCheInserisce10);

                                            System.out.println("il mezzo è in manutenzione ? (true or false).");
                                            Boolean quelloCheInserisce11 = sca.nextBoolean();
                                            MezzoCheStaModificandoLutenteInQuestoMomento.setIn_manutenzione(quelloCheInserisce11);


                                            try {
                                                //salvataggio nel db
                                                mezzoDAO.update(id, MezzoCheStaModificandoLutenteInQuestoMomento);

                                            } catch (NotFoundException e) {
                                                System.err.println(e.getMessage());
                                            }


                                            break;
                                        case 2:

                                            System.out.println("Elenco di tutti i mezzi: ");
                                            mezzoDAO.findAll().stream().forEach(System.out::println);
                                            sca.nextLine();

                                            System.out.println("\nInserisci l'ID del Tram da Aggiornare:");
                                            String idInseritoTram = sca.nextLine();
                                            UUID id1 = UUID.fromString(idInseritoTram);

                                            Mezzo TramCheStaModificandoLutenteInQuestoMomento = new Tram();

                                            System.out.println("il mezzo è in servizio ? (true or false)");
                                            Boolean quelloCheInserisce15 = sca.nextBoolean();
                                            TramCheStaModificandoLutenteInQuestoMomento.setIn_servizio(quelloCheInserisce15);

                                            System.out.println("il mezzo è in manutenzione ? (true or false).");
                                            Boolean quelloCheInserisce16 = sca.nextBoolean();
                                            TramCheStaModificandoLutenteInQuestoMomento.setIn_manutenzione(quelloCheInserisce16);


                                            try {
                                                //salvataggio nel db
                                                mezzoDAO.update(id1, TramCheStaModificandoLutenteInQuestoMomento);

                                            } catch (NotFoundException e) {
                                                System.err.println(e.getMessage());
                                            }

                                            break;
                                        default:
                                            System.out.println(dioPorco + " ❌ " + " Inserisci un numero valido.");

                                    }


                                    break;
                                case 4:
                                    //elimina mezzo


                                    System.out.println("Elenco mezzi: ");
                                    mezzoDAO.findAll().stream().forEach(System.out::println);
                                    System.out.println("\nElimina mezzo tramite id: ");

                                    String idDeleteMezzo = sca.nextLine();
                                    mezzoDAO.deleteFromId(UUID.fromString(idDeleteMezzo));
                                    break;

                                case 5:
                                    //visualizza mezzi in manutenzione

                                    System.out.println("Elenco tutti i Mezzi in Manutenzione: ");
                                    mezzoDAO.mezziManutenzione().stream().forEach(System.out::println);

                                    break;

                                default:
                                    System.out.println(quelloCheInserisceAdminInModaleMezzi + " ❌ " + " Inserisci un numero valido.");

                            }


                            break;
                        case 3:

                            System.out.println("\n<-- Modale Distributori -->");
                            System.out.println("Visualizza Distributore --> 1️⃣");
                            System.out.println("Modificare Distributore --> 2️⃣"); //attivo o fuori servizio
                            int scelta = sca.nextInt();
                            switch (scelta) {
                                case 1:
                                    System.out.println("Elenco Distributori:");
                                    distributoreautomaticoDAO.findAll().stream().forEach(System.out::println);
                                    break;
                                case 2:
                                    System.out.println("Elenco di tutti i distributori: ");
                                    distributoreautomaticoDAO.findAll().stream().forEach(System.out::println);
                                    sca.nextLine();

                                    System.out.println("\nInserisci l'ID del distributore da Aggiornare:");
                                    long idInseritoDistributore = Long.parseLong(sca.nextLine());


                                    DistributoreAutomatico distributoreCheStaModificandoLutenteInQuestoMomento = new DistributoreAutomatico();

                                    System.out.println("il distributore è in attivo ? (true or false)");
                                    Boolean quelloCheInserisce17 = sca.nextBoolean();
                                    distributoreCheStaModificandoLutenteInQuestoMomento.setAttivo(quelloCheInserisce17);

                                    try {
                                        //salvataggio nel db
                                        distributoreautomaticoDAO.update(idInseritoDistributore, distributoreCheStaModificandoLutenteInQuestoMomento);

                                    } catch (NotFoundException e) {
                                        System.err.println(e.getMessage());
                                    }


                            }


                            break;
                        case 4:

                            System.out.println("\n<-- Modale Punti Vendita -->");
                            System.out.println("Visualizza Punti Vendita --> 1️⃣");
                            scelta = sca.nextInt();
                            switch (scelta) {
                                case 1:
                                    System.out.println("Elenco Distributori:");
                                    puntovenditaDAO.findAll().stream().forEach(System.out::println);
                                    break;
                                default:
                                    System.out.println("Inserisci un altro numero coglione");
                                    break;
                            }

                            break;
                        default:
                            System.out.println(dentroAdmin + " ❌ " + " Inserisci un numero valido.");

                    }


                } else {
                    System.out.println("❌ Admin Non Autorizzato !!❌");
                    //nota RICORDIAMOCI DI INSERIRLO NEL WHILE COSI RESTARTA
                }
                break;


            default:
                //nota RICORDIAMOCI DI INSERIRLO NEL WHILE COSI RESTARTA
                System.out.println(x + " ❌ " + " Inserisci un numero valido.");
        }


    }
}
//------------------COSA PUò FARE UN UTENTE ------------------

//1) controllare il numero della tessere personale
//2) può comprare un abbonamento personale    **  (da un ditributore automatico o da negozio fisico)
//3) può comprare un biglietto personale   **   (da un ditributore automatico o da negozio fisico)
//4) può visionare un abbonamento personale
//5) può visionare un biglietto personale
//6) può vedere le sue info personali
//7)

//8) creare utente
//9) modificare il proprio utente
//10 ricordarsi di visionare


//------------------COSA PUò FARE UN ADMIN ------------------

//1) creare tratte
//2) creare mezzi (autobus + trum)
//3) controllare lo stato dei mezzi
//4) settare se il mezzo è in servizio
//5) settare se il mezzo è in manutenzione
//6) assegnare tratte
//7)


//Note se il distributore automatico è fuori servizio biglietto nooo!!!!!!!!!!!!!!!!!!