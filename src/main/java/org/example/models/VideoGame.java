package org.example.models;

import java.util.UUID;

@Getter
@Setter


public class VideoGame {

    private final UUID id;
    private String title;
    private int HoursPlayed;
    private boolean completed;

    public VideoGame(String title, int hoursPlayed) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.HoursPlayed = hoursPlayed;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.id + " - " + this.completed;
    }
}
