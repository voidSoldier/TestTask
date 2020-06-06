package com.javajunior.testtask;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("Entity not found!");
    }
}
