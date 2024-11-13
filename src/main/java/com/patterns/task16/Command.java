package com.patterns.task16;

/*Command интерфейс*/
public interface Command<T> {
    T execute();
}
