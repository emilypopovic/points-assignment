package com.epopovic.points;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RouteResponseTest {

    @Mock
    RouteResponse routeResponse = new RouteResponse();

    @Test
    public void testRouteResponseMethods()  {
        List<TrackObject> trackObjectList = Lists.newArrayList(new TrackObject(), new TrackObject());
        List<TravelLogObject> travelLogObjectList  = Lists.newArrayList(new TravelLogObject(), new TravelLogObject());
        RouteObject routeObject = new RouteObject(trackObjectList, travelLogObjectList);
        this.routeResponse.setRoute(routeObject);

        when(this.routeResponse.getRoute()).thenReturn(routeObject);

        assertNotNull(this.routeResponse.getRoute());
        assertEquals(this.routeResponse.getRoute(), routeObject);
    }
}
