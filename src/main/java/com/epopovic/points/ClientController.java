package com.epopovic.points;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@RestController
@RequestMapping("/api")
class ClientController {

    private final Logger log = LoggerFactory.getLogger(ClientController.class);
    private final WebClient webClient;
    private final RouteValidationService routeValidationService;

    public ClientController() {
        this.webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create().followRedirect(true)
                ))
                .baseUrl("http://localhost:5000/autonomous-car/routes")
                .build();
        this.routeValidationService = new RouteValidationService();
    }

    @GetMapping("/empty-route")
    String getEmptyRoute() {
        log.info("Request to client for empty route");
        RouteResponse clientResponse = this.webClient.get()
                .uri("/empty-route")
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals,
                        response -> Mono.error(new ServiceException("Error with request. Please check the URL." + response.statusCode().value())))
                .bodyToMono(RouteResponse.class)
                .block();
        assert clientResponse != null;
        return this.routeValidationService.validateRoute(clientResponse);
    }

    @GetMapping("/success-no-obstacles")
    String getSuccessNoObstaclesRoute() {
        RouteResponse clientResponse = this.webClient.get()
                .uri("/success-no-obstacles")
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals,
                        response -> Mono.error(new ServiceException("Error with request. Please check the URL." + response.statusCode().value())))
                .bodyToMono(RouteResponse.class)
                .block();
        assert clientResponse != null;
        return this.routeValidationService.validateRoute(clientResponse);
    }

    @GetMapping("/success-with-obstacles")
    String getSuccessWithObstaclesRoute() {
        RouteResponse clientResponse = this.webClient.get()
                .uri("/success-with-obstacles")
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals,
                        response -> Mono.error(new ServiceException("Error with request. Please check the URL." + response.statusCode().value())))
                .bodyToMono(RouteResponse.class)
                .block();
        assert clientResponse != null;
        return this.routeValidationService.validateRoute(clientResponse);
    }

    @GetMapping("/failure-out-of-bounds")
    String getFailureOutOfBoundsRoute() {
        RouteResponse clientResponse = this.webClient.get()
                .uri("/failure-out-of-bounds")
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals,
                        response -> Mono.error(new ServiceException("Error with request. Please check the URL." + response.statusCode().value())))
                .bodyToMono(RouteResponse.class)
                .block();
        assert clientResponse != null;
        return this.routeValidationService.validateRoute(clientResponse);
    }

    @GetMapping("/failure-hits-obstacle")
    String getFailureHitsObstacleRoute() throws JsonProcessingException {
        RouteResponse clientResponse = this.webClient.get()
                .uri("/failure-hits-obstacle")
                .retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals,
                        response -> Mono.error(new ServiceException("Error with request. Please check the URL." + response.statusCode().value())))
                .bodyToMono(RouteResponse.class)
                .block();
        assert clientResponse != null;
        return this.routeValidationService.validateRoute(clientResponse);
    }

    @GetMapping("/random")
    String getRandomRoute() {
        RouteResponse clientResponse;
        try {
             clientResponse = this.webClient.get()
                    .uri("/random")
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError,
                            error -> Mono.error(new RuntimeException("API not found")))
                     .onStatus(HttpStatus::is5xxServerError,
                            error -> Mono.error(new RuntimeException("Server is not responding")))
                     .onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals,
                             response -> Mono.error(new ServiceException("Error with request. Please check the URL." + response.statusCode().value())))
                     .bodyToMono(RouteResponse.class)
                     .block();
        }
        catch (RuntimeException e) {
            return "{\"status\": \"error\", \"message\": \"Runtime exception attempting to connect to client\"}";
        }

        assert clientResponse != null;
        return this.routeValidationService.validateRoute(clientResponse);
    }
}