package com.epopovic.points;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
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
