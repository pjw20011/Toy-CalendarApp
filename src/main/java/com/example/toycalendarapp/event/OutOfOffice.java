package com.example.toycalendarapp.event;

import com.example.toycalendarapp.event.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

public class OutOfOffice extends AbstractEvent{
    public OutOfOffice(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    @Override
    protected void update(AbstractAuditableEvent update) {

    }

    public void print() {
    }

    public boolean support(EventType type) {
        return type == EventType.OutOfOffice;
    }
}
