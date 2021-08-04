package com.epopovic.points;


import java.util.*;

public class RouteValidationService {

    public RouteValidationService() {}

    static String validateRoute(RouteResponse routeResponse) {
        assert routeResponse != null;
        List<TrackObject> tracksObject = routeResponse.getRoute().getTrack();
        List<TravelLogObject> travelLogsObject = routeResponse.getRoute().getTravelLog();

        //determine the last position of both routes
        int finalTrackIndex = tracksObject.size()>0 ? tracksObject.get(tracksObject.size() - 1).getPosition() : 0;
        int finalTravelLogIndex = travelLogsObject.size()>0 ? travelLogsObject.get(travelLogsObject.size() - 1).getPosition() : 0;
        int finalIndex = Math.max(finalTrackIndex, finalTravelLogIndex);

        //map the position to the obstacles in that position
        //contains position and obstacles list
        Map<Integer, String[]> obstacleKeyMap = new HashMap<>();
        for (TrackObject track: tracksObject) {
            obstacleKeyMap.put(track.getPosition(), track.getObstacles());
        }

        //map the position to the lane change for that position
        //contains position and laneChange
        Map<Integer, String> travelLogKeyMap = new HashMap<>();
        for (TravelLogObject travelLog: travelLogsObject) {
            travelLogKeyMap.put(travelLog.getPosition(), travelLog.getLaneChange());
        }

        //need to loop through success with objects to check if you go around
        //for each position, check obstacle key map for obstacle, if none continue
        char currentLane = 'b';
        for(int i=0; i <= finalIndex; i++) {

            //if that position has a travel log entry
            //travelLog:[.....]
            if(travelLogKeyMap.containsKey(i)) {
                String laneChange = travelLogKeyMap.get(i);
                if(laneChange.equals("left")) {
                    currentLane--;
                }
                else {
                    currentLane++;
                }
                if(currentLane < 'a' || currentLane > 'c') {
                    return "{\"status\": \"error\", \"position\": " + i + "}";
                }
            }
            //if that position has an obstacle entry
            //track:[.....]
            if(obstacleKeyMap.containsKey(i)) {
                String[] obstacles = obstacleKeyMap.get(i);

                //check if there is an obstacle in the current lane
                if (Arrays.asList(obstacles).contains(String.valueOf(currentLane))) {
                    return "{\"status\": \"error\", \"position\": " + i + "}";
                }
            }
        }
        return "{\"status\": \"success\"}";
    }
}
