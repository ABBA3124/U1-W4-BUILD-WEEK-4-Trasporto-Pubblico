package org.gestionetrasportopubblico.entities;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private static Faker faker = new Faker();

    public static Utente generateUtente() {
        String nome = faker.name().firstName();
        String cognome = faker.name().lastName();
        Tessera tessera = new Tessera();

        return new Utente(nome, cognome, tessera);
    }

    public static List<Utente> generaUtenti() {
        List<Utente> utenti = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            generateUtente();
        }
    }

}
