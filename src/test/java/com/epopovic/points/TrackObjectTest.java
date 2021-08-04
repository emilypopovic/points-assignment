package com.epopovic.points;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TrackObjectTest {

    @Mock
    TrackObject trackObject;

    @Test
    public void testTrackObjectGetters()  {
        String[] obstacles = {"a","b"};
        int position = 5;

        when(this.trackObject.getObstacles()).thenReturn(obstacles);
        when(this.trackObject.getPosition()).thenReturn(position);

        assertNotNull(this.trackObject.getObstacles());
        assertSame(this.trackObject.getObstacles(), obstacles);
        assertEquals(this.trackObject.getPosition(), position);
    }
}
