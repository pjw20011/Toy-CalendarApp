package com.example.toycalendarapp.reader;

import com.example.toycalendarapp.event.Meeting;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class EventCsvReader {

    private final RawCsvReader rawCsvReader;

    public EventCsvReader(RawCsvReader rawCsvReader) {
        this.rawCsvReader = rawCsvReader;
    }

    public List<Meeting> readMeetings(String path) throws IOException{
        List<Meeting> result = new ArrayList<>();

        // 데이터를 읽는 부분
        List<String[]> read = rawCsvReader.readAll(path);
        for(int i= 0; i< read.size(); i++){
            if (skipHeader(i)) {
                continue;
            }

            String[] each = read.get(i);

            //Meeting 으로 변환하는 부분
            result.add(
                    new Meeting(
                            Integer.parseInt(each[0]), // ID
                            each[2], // 제목
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[6].trim(), // 앞뒤 공백 제거
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), // T 포함된 형식
                                    ZoneId.of("Asia/Seoul")),
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[7].trim(), // 앞뒤 공백 제거
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")), // T 포함된 형식
                                    ZoneId.of("Asia/Seoul")),
                            new HashSet<>(Arrays.asList(each[3].split(","))), // 참가자 리스트
                            each[4], // 장소
                            each[5]  // 설명
                    )
            );

        }


        return result;
    }

    private boolean skipHeader(int i) {
        return i == 0;
    }

    private List<String[]> readAll(String path) throws IOException {
        InputStream in = getClass().getResourceAsStream(path);
        InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);

        CSVReader csvReader = new CSVReader(reader);
        return csvReader.readAll();
    }

}
