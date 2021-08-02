package com.epopovic.points;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientControllerTest {

    @Mock
    private TravelLogRepository travelLogRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetTravelLogs() {

        TravelLog mockedTravelLog = new TravelLog("1", "a", 0);
        when(travelLogRepository.findById("1")).thenReturn(mockedTravelLog);

        verify(travelLogRepository, times(1)).findById("it1");
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
