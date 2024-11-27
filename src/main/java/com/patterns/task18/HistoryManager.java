package com.patterns.task18;

import java.util.ArrayList;
import java.util.List;

// Caretaker

public class HistoryManager {
    private final List<TrainingPlanMemento> history = new ArrayList<>();

    public void saveState(TrainingPlanMemento memento) {
        history.add(memento);
    }

    public TrainingPlanMemento getPreviousState() {
        if (!history.isEmpty()) {
            return history.remove(history.size() - 1);
        }
        throw new IllegalStateException("No previous states available");
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }
}
