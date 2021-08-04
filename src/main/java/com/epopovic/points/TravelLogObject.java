package com.epopovic.points;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
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
