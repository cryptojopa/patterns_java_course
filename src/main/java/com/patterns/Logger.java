package com.patterns;

import lombok.Getter;

/* Реализует паттерн Singleton*/
public class Logger {
    @Getter
    private static final Logger INSTANCE = new Logger();

    private Logger() {
        //some resources initialization
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
