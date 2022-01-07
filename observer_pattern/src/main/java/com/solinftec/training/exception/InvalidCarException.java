package com.solinftec.training.exception;

public class InvalidCarException extends Exception {

    public InvalidCarException() {
        super("Specified Car not found");
    }
}
