package com.example.toycalendarapp.event;

import java.time.ZonedDateTime;

public class OutOfOffice extends AbstractEvent{
    public OutOfOffice(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    public void print() {
    }

    public boolean support(EventType type) {
        return type == EventType.OutOfOffice;
    }
}
