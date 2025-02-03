package com.example.toycalendarapp;

import com.example.toycalendarapp.event.*;
import com.example.toycalendarapp.reader.EventCsvReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ToyCalendarAppApplication {

    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader();
        String meetingCsvPath = "/data/meeting.csv";

        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(each -> schedule.add(each));

        schedule.printAll();
       // SpringApplication.run(ToyCalendarAppApplication.class, args);
    }

}
