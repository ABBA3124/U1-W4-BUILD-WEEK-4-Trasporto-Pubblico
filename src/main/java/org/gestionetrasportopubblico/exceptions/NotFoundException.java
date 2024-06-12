package org.gestionetrasportopubblico.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("----------The item with id: " + id + " has not been found.");
    }

    public NotFoundException(UUID id) {
        super("----------The item with id: " + id.toString() + " has not been found.");
    }
}
