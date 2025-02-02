package com.example.toycalendarapp;

import com.example.toycalendarapp.event.AbstractEvent;
import com.example.toycalendarapp.event.Event;
import com.example.toycalendarapp.event.Meeting;
import com.example.toycalendarapp.event.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ToyCalendarAppApplication {

    public static void main(String[] args) {
        List <AbstractEvent>list = new ArrayList<>();
        HashSet<String> participants = new HashSet<>();
        participants.add("박정원");
        Meeting meeting1 = new Meeting(
                1,"meeting1", ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                participants, "MeetingRoomA", "스터디"
        );

        list.add(meeting1);

        Todo todo1 = new Todo(
                2, "todo1", ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                "할 일 적기"
        );
        list.add(todo1);

        list.forEach(Event::print);

        list.stream()
                .filter(each -> each instanceof Meeting)
                .collect(Collectors.toList());

        SpringApplication.run(ToyCalendarAppApplication.class, args);
    }

}
