package com.epopovic.points;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ClientControllerTest {

    @Mock
    ClientController clientMock;

    @Test
    public void testClient() throws JsonProcessingException {
        String successString = "{\"status\": \"success\"}";
        String failString = "{\"status\": \"error\", \"position\": 3}";

        when(clientMock.getEmptyRoute()).thenReturn(successString);
        when(clientMock.getSuccessNoObstaclesRoute()).thenReturn(successString);
        when(clientMock.getSuccessWithObstaclesRoute()).thenReturn(successString);
        when(clientMock.getFailureOutOfBoundsRoute()).thenReturn(failString);
        when(clientMock.getFailureHitsObstacleRoute()).thenReturn(failString);
        when(clientMock.getRandomRoute()).thenReturn(successString);

        assertEquals(clientMock.getEmptyRoute(), successString);
        assertEquals(clientMock.getSuccessNoObstaclesRoute(), successString);
        assertEquals(clientMock.getSuccessWithObstaclesRoute(), successString);
        assertEquals(clientMock.getFailureHitsObstacleRoute(), failString);
        assertEquals(clientMock.getFailureOutOfBoundsRoute(), failString);
        assertEquals(clientMock.getRandomRoute(), successString);
    }
}
