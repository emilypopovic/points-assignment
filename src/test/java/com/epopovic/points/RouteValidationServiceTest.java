package com.epopovic.points;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RouteValidationServiceTest {

    RouteResponse routeResponse;

    @Before
    public void initialize() {
        TrackObject trackObject1 = new TrackObject(new String[]{"a"}, 2);
        TrackObject trackObject2 = new TrackObject(new String[]{"b"}, 5);
        TravelLogObject travelLogObject1 = new TravelLogObject("left", 5);
        TravelLogObject travelLogObject2 = new TravelLogObject("right", 6);

        List<TrackObject> trackObjectList = Lists.newArrayList(trackObject1, trackObject2);
        List<TravelLogObject> travelLogObjectList  = Lists.newArrayList(travelLogObject1, travelLogObject2);
        RouteObject routeObject = new RouteObject(trackObjectList, travelLogObjectList);
        routeResponse.setRoute(routeObject);
    }

    @Test
    public void testRouteObjectGetters()  {
        String result = this.getRouteValidationService();

        assertNotNull(result);
        assertEquals(result, "{\"status\": \"success\"}");
    }

    String getRouteValidationService(){
        return RouteValidationService.validateRoute(this.routeResponse);
    }
}
