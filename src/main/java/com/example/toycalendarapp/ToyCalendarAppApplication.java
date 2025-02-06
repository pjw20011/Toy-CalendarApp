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

        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(each -> schedule.add(each));

        Meeting meeting = meetings.get(0);
        meeting.print();


        System.out.println("수정 후.....");

        meetings.get(0).validateUpdate(
                new UpdateMeeting(
                        "new title",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "A",
                        "new agenda"
                )
        );

        meeting.delete(true);
        meeting.print();

        System.out.println("삭제 후 수정 .....");

        meetings.get(0).validateUpdate(
                new UpdateMeeting(
                        "new title2",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "B",
                        "new agenda2"
                )
        );



       // SpringApplication.run(ToyCalendarAppApplication.class, args);
    }

}
