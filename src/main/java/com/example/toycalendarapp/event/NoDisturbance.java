package com.example.toycalendarapp.event;

import com.example.toycalendarapp.event.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

public class NoDisturbance extends AbstractEvent{
    public NoDisturbance(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    @Override
    protected void update(AbstractAuditableEvent update) {

    }

    public void print() {
        System.out.printf("[방해금지] %s%n", getTitle());
    }

    public boolean support(EventType type) {
        return type == EventType.NoDisturbance;
    }
}
