package com.example.toycalendarapp.event;

import java.time.ZonedDateTime;

public class OutOfOfice extends AbstractEvent{
    public OutOfOfice(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    public void print() {

    }
}
