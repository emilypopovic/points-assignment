package com.epopovic.points;

public class TravelLogObject {
    private String laneChange;
    private int position;

    public TravelLogObject() {}

    public TravelLogObject(String laneChange, int position) {
        this.laneChange = laneChange;
        this.position = position;
    }

    public String getLaneChange() {
        return laneChange;
    }

    public int getPosition() {
        return position;
    }
}
