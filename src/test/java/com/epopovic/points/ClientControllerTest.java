package com.epopovic.points;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class ClientControllerTest {


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetTravelLogs() {

        //RouteObject mockedTravelLog = new RouteObject("1", "a", 0);
        //when(travelLogRepository.findById("1")).thenReturn(mockedTravelLog);

        //verify(travelLogRepository, times(1)).findById("it1");
    }

    @Test
    void testGetTravelLogsById() {
    }

    @Test
    void testCreateTravelLog() {
    }

    @Test
    void testUpdateTravelLog() {
    }

    @Test
    void testDeleteTravelLog() {
    }
}
