package com.patterns;

public class Service {
    public void doWork() {
        Logger logger = Logger.getINSTANCE();
        logger.log("Application is starting.");
        logger.log("Something working");
        logger.log("Something still working");
        logger.log("Something stop working");
    }
}
