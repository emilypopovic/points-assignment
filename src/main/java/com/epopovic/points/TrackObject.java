package com.epopovic.points;

public class TrackObject {
    private String[] obstacles;
    private int position;

    public TrackObject() {}

    public TrackObject(String[] obstacles, int position) {
        this.obstacles = obstacles;
        this.position = position;
    }

    public String[] getObstacles() {
        return obstacles;
    }

    public int getPosition() {
        return position;
    }
}
