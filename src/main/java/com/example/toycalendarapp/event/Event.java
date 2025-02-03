package com.example.toycalendarapp.event;

public interface Event {
    void print();

    boolean support(EventType type);
}
