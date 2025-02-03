package com.example.toycalendarapp.event;

import com.example.toycalendarapp.exception.InvalidEventException;
import java.time.Duration;
import java.time.ZonedDateTime;

public abstract class AbstractEvent implements Event {
    private final int id;
    private String title;

    private ZonedDateTime startAt;
    private ZonedDateTime endAt;
    private Duration duration;

    private final ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;

    private boolean deletedYn;

    protected AbstractEvent(int id, String title, ZonedDateTime startAt,
                            ZonedDateTime endAt) {
        if(startAt.isAfter(endAt)) {
            throw new InvalidEventException(
                    String.format("시작시간이 종료시간보다 늦습니다. startAt: %s, endAt: %s",
                            startAt, endAt)
            );
        }

        this.id = id;
        this.title = title;
        this.startAt = startAt;
        this.endAt = endAt;
        this.duration = Duration.between(startAt, endAt);

        this.createdAt = ZonedDateTime.now();
        this.modifiedAt = ZonedDateTime.now();

        this.deletedYn = false;
    }

    public String getTitle() {
        return title;
    }

    public ZonedDateTime getStartAt() {
        return startAt;
    }

    public ZonedDateTime getEndAt() {
        return endAt;
    }

}
