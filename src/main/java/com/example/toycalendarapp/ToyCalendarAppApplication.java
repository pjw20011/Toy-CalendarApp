package com.example.toycalendarapp;

import com.example.toycalendarapp.event.*;
import com.example.toycalendarapp.event.update.UpdateMeeting;
import com.example.toycalendarapp.reader.EventCsvReader;
import com.example.toycalendarapp.reader.RawCsvReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class ToyCalendarAppApplication {

    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader(new RawCsvReader());
        String meetingCsvPath = "/data/meeting.csv";
        String noDisturbanceCsvPath = "/data/no_disturbance.csv";
        String outOfOfficeCsvPath = "/data/out_of_office.csv";
        String toDoCsvPath = "/data/to_do.csv";

        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(schedule::add);

        List<NoDisturbance> noDisturbances = csvReader.readNoDisturbance(noDisturbanceCsvPath);
        noDisturbances.forEach(schedule::add);

        List<OutOfOffice> outOfOffices = csvReader.readOutOfOffice(outOfOfficeCsvPath);
        outOfOffices.forEach(schedule::add);

        List<Todo> todos = csvReader.readTodo(toDoCsvPath);
        todos.forEach(schedule::add);

        schedule.printAll();


       // SpringApplication.run(ToyCalendarAppApplication.class, args);
    }

}
