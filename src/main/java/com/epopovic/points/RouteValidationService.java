package com.epopovic.points;


import java.util.*;

public class RouteValidationService {

    public RouteValidationService() {}

    static String validateRoute(RouteResponse routeResponse) {

        assert routeResponse != null;
        List<TrackObject> tracksObject = routeResponse.getRoute().getTrack();
        List<TravelLogObject> travelLogsObject = routeResponse.getRoute().getTravelLog();

        HashMap<Integer, String[]> obstacleKeyMap = new HashMap<>();

        //check for empty travel log with obstacles
        //for each entry in obstacleMap check if there is an obstacle in start lane "b"
        if(travelLogsObject.isEmpty() && !tracksObject.isEmpty()) {
            for (TrackObject track: tracksObject) {
                boolean result = Arrays.asList(track.getObstacles()).contains("b");
                if (result) {
                    return "{\"status\": \"error\", \"position\": " + track.getPosition() + "}";
                }
                obstacleKeyMap.put(track.getPosition(), track.getObstacles());
            }
            return "{\"status\": \"error\", \"position\": \"what\"}";

        }
        else if(!travelLogsObject.isEmpty()) {
            //determine where the car is travelling
            //laneChange and position
            int currentLaneIndex = 1;
            int currentPosition = 0;

            for (TravelLogObject travelLog: travelLogsObject) {
                if(travelLog.getLaneChange().equals("left")) {
                    currentLaneIndex--;
                }
                else {
                    currentLaneIndex++;
                }
                if(currentLaneIndex < 0 || currentLaneIndex > 2) {
                    return "{\"status\": \"error\", \"position\": " + currentPosition + "}";
                }
                currentPosition = travelLog.getPosition();
            }
        }

        return "{\"status\": \"success\"}";
    }

}
