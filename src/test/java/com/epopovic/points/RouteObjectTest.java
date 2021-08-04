package com.epopovic.points;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class RouteObjectTest {

    @Mock
    RouteObject routeObject;

    @Test
    public void testRouteObjectGetters()  {
        List<TrackObject> trackObjectList = Lists.newArrayList(new TrackObject(), new TrackObject());
        List<TravelLogObject> travelLogObjectList  = Lists.newArrayList(new TravelLogObject(), new TravelLogObject());

        when(this.routeObject.getTrack()).thenReturn(trackObjectList);
        when(this.routeObject.getTravelLog()).thenReturn(travelLogObjectList);

        assertNotNull(this.routeObject.getTrack());
        assertNotNull(this.routeObject.getTravelLog());
        assertEquals(this.routeObject.getTrack(), trackObjectList);
        assertEquals(this.routeObject.getTravelLog(), travelLogObjectList);
    }
}
