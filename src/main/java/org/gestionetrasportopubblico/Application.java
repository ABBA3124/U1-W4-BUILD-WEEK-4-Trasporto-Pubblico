package org.gestionetrasportopubblico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.dao.*;
import org.gestionetrasportopubblico.entities.*;
import org.gestionetrasportopubblico.exceptions.NotFoundException;

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

        System.out.println("\n\t🚌Benvenuto in Trasporti🚃 S.R.L.");

        System.out.println("\nSeleziona Modalità: ");
        System.out.println("\n🙋Sei un Cliente? digita --> 1️⃣");
        System.out.println("⚙️Modalità Admin🔧 --> 2️⃣");
        System.out.println("⬇️");
        int x = sca.nextInt();

        switch (x) {
            case 1:
                System.out.println("🙋sei dentro cliente🙋");
                //qui dentro tutto quello che può fare un cliente
                break;
            case 2:
                Admin fs0224 = new Admin("Davide", "Abbadessa");
                //qui dentro login per verificare se admin è autorizzato
                System.out.println("🔐Inserisci Codice di sicurezza🔐");
                int codice = sca.nextInt();
                if (codice == fs0224.getCodice()) {
                    System.out.println("🔓Password Corretta🔓");
                    //qui dentro tutto quello che può fare un admin

                    //Lista di cose selezionabili
                    System.out.println(fs0224);

                    System.out.println("\n<-- ⚙️Admin Menu🔧 -->");
                    System.out.println("Tratta --> 1️⃣"); //TUTTO OK COMPLETATO✔️
                    System.out.println("Mezzo --> 2️⃣");
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


                            break;
                        case 4:

                            System.out.println("\n<-- Modale Punti Vendita -->");
                            System.out.println("Visualizza Punti Vendita --> 1️⃣");

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
//6) può vedere le sue info personale
//7) può vedere le sue info personale

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