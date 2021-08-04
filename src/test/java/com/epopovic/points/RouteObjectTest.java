package com.epopovic.points;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RouteObjectTest {

    @Mock
    RouteObject mockRouteObject;

    @Test
    public void testObject()  {
        this.mockRouteObject = new RouteObject();

        List<TrackObject> trackObjectList = Lists.newArrayList(new TrackObject(), new TrackObject());
        List<TravelLogObject> travelLogObjectList  = Lists.newArrayList(new TravelLogObject(), new TravelLogObject());

        when(mockRouteObject.getTrack()).thenReturn(trackObjectList);
        when(mockRouteObject.getTravelLog()).thenReturn(travelLogObjectList);

        assertEquals(mockRouteObject.getTrack(), trackObjectList);
        assertEquals(mockRouteObject.getTravelLog(), travelLogObjectList);
    }

    @Test
    void testObjectTip() {
    }
}
