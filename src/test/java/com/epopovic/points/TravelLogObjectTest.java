package com.epopovic.points;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TravelLogObjectTest {

    @Mock
    TravelLogObject travelLogObject;

    @Test
    public void testTravelLogObjectGetters()  {
        String laneChange = "left";
        int position = 3;

        when(this.travelLogObject.getLaneChange()).thenReturn(laneChange);
        when(this.travelLogObject.getPosition()).thenReturn(position);

        assertNotNull(this.travelLogObject.getLaneChange());
        assertEquals(this.travelLogObject.getLaneChange(), laneChange);
        assertEquals(this.travelLogObject.getPosition(), position);
    }
}
