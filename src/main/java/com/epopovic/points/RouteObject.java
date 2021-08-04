package com.epopovic.points;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "track",
        "travelLog"
})
public class RouteObject {

    @JsonProperty("track")
    private List<TrackObject> track;
    @JsonProperty("travelLog")
    private List<TravelLogObject> travelLog;

    public RouteObject() {}

    public RouteObject(List<TrackObject> track, List<TravelLogObject> travelLog) {
        this.track = track;
        this.travelLog = travelLog;
    }

    @JsonProperty("track")
    public List<TrackObject> getTrack() {
        return track;
    }

    @JsonProperty("travelLog")
    public List<TravelLogObject> getTravelLog() {
        return travelLog;
    }
}
