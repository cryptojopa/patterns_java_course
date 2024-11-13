package com.patterns.task16;

import org.springframework.stereotype.Component;

/* Invoker */
@Component
public class CommandInvoker {
    public <T> T executeCommand(Command<T> command) {
        return command.execute();
    }
}
