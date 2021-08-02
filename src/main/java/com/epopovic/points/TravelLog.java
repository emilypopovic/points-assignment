package com.epopovic.points;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TravelLog {

    @Id
    private String id;
    private String lane;
    private int position;

    public TravelLog() {}

    public TravelLog(String id, String lane, int position) {
        this.id = id;
        this.lane = lane;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getLane() {
        return lane;
    }

    public int getPosition() {
        return position;
    }
}
