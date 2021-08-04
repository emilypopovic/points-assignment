package com.epopovic.points;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class ClientControllerTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetTravelLogs() {

        //RouteObject mockedTravelLog = new RouteObject("1", "a", 0);
        //when(travelLogRepository.findById("1")).thenReturn(mockedTravelLog);

        //verify(travelLogRepository, times(1)).findById("it1");
    }

    @Test //(expected = RuntimeException.class)
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
    }

    @Test
    public void testGetTravelLogsById() {
    }

    @Test
    public void testCreateTravelLog() {
    }

    @Test
    public void testUpdateTravelLog() {
    }

    @Test
    public void testDeleteTravelLog() {
    }
}
