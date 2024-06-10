package org.gestionetrasportopubblico;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.gestionetrasportopubblico.dao.UtenteDAO;
import org.gestionetrasportopubblico.entities.Utente;

import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W4-BUILD-WEEK-4-Trasporto-Pubblico");

    public static void main(String[] args) {
        System.out.println("Start build week");

        UtenteDAO utenteDAO = new UtenteDAO();

        //crea utente
//        Utente utente = new Utente();
//        utente.setNome("emanuele");
//        utente.setCognome("Ivfdvdfvdfv");
//        utente.setNumeroTessera("46461651");
//        utente.setDataScadenzaTessera(LocalDate.now().plusYears(5));
//        utenteDAO.create(utente);


//        System.out.println(utente);

        Utente daTrovare = utenteDAO.findById(UUID.fromString("828028ab-16c2-4657-9e50-1f5ec8c55c5b"));
        System.out.println("Utente trovato: " + daTrovare.getNome() + " " + daTrovare.getCognome());


    }
}
