package com.example.toycalendarapp.event;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<AbstractEvent> events = new ArrayList<>();

    public void add(AbstractEvent event) {
        if(hasScheduleConflictwith(event)) {
            return;
        }
        this.events.add(event);
    }

    public void printAll() {
        events.forEach(Event::print);
    }

    public void printBy(EventType type) {
        events.stream()
                .filter(event -> event.support(type))
                .forEach(Event::print);
    }

    private boolean hasScheduleConflictwith(AbstractEvent event) {
        return events.stream()
                .anyMatch(each ->
                        (event.getStartAt().isBefore(each.getEndAt()) && event.getEndAt().isAfter(each.getStartAt()))
                        ||(event.getEndAt().isAfter(each.getStartAt())) && event.getEndAt().isBefore(each.getEndAt()));
    }
}
