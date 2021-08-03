package com.epopovic.points;

public class RouteObject {

    private TrackObject[] track;
    private TravelLogObject[] travelLog;

    public RouteObject() {}

    public RouteObject(TrackObject[] track, TravelLogObject[] travelLog) {
        this.track = track;
        this.travelLog = travelLog;
    }

    public TrackObject[] getTrack() {
        return track;
    }

    public TravelLogObject[] getTravelLog() {
        return travelLog;
    }
}
