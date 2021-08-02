package com.epopovic.points;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
class ClientController {

    private final Logger log = LoggerFactory.getLogger(ClientController.class);
    private final TravelLogRepository travelLogRepository;
    private final WebClient webClient;

    public ClientController(TravelLogRepository travelLogRepository) {
        this.travelLogRepository = travelLogRepository;
        this.webClient = WebClient.builder().baseUrl("http://localhost:5000/autonomous-car/routes").build();
    }

    @GetMapping("/empty-route")
    String getEmptyRoute() {
        return this.webClient.get()
                .uri("/empty-route")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @GetMapping("/success-no-obstacles")
    Collection<TravelLog> getSuccessNoObstaclesRoute() {

        Flux<TravelLog> travelLogs = this.webClient.get()
                .uri("/success-no-obstacles")
                .retrieve()
                .bodyToFlux(TravelLog.class);

        return travelLogRepository.findAll();
    }

    @GetMapping("/success-with-obstacles")
    Collection<TravelLog> getSuccessWithObstaclesRoute() {

        Flux<TravelLog> travelLogs = this.webClient.get()
                .uri("/success-with-obstacles")
                .retrieve()
                .bodyToFlux(TravelLog.class);

        return travelLogRepository.findAll();
    }

    @GetMapping("/failure-out-of-bounds")
    Collection<TravelLog> getFailureOutOfBoundsRoute() {

        Flux<TravelLog> travelLogs = this.webClient.get()
                .uri("/failure-out-of-bounds")
                .retrieve()
                .bodyToFlux(TravelLog.class);

        return travelLogRepository.findAll();
    }

    @GetMapping("/failure-hits-obstacle")
    Collection<TravelLog> getFailureHitsObstacleRoute() {

        Flux<TravelLog> travelLogs = this.webClient.get()
                .uri("/failure-hits-obstacle")
                .retrieve()
                .bodyToFlux(TravelLog.class);

        return travelLogRepository.findAll();
    }

    @GetMapping("/random")
    Collection<TravelLog> getRandomRoute() {

        Flux<TravelLog> travelLogs = this.webClient.get()
                .uri("/random")
                .retrieve()
                .bodyToFlux(TravelLog.class);

        return travelLogRepository.findAll();
    }


    //-------------------
    //test below

    @GetMapping("/travel-logs")
    Collection<TravelLog> getTravelLogs() {
        log.info("Request to get all travel logs");
        return travelLogRepository.findAll();
    }

    @GetMapping("/travel-log/{id}")
    ResponseEntity<?> getTravelLogsById(@PathVariable Long id) {
        Optional<TravelLog> travelLogs = travelLogRepository.findById(id);
        return travelLogs.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/travel-log")
    ResponseEntity<TravelLog> createTravelLog(@RequestBody TravelLog travelLog) throws URISyntaxException {
        TravelLog result = travelLogRepository.save(travelLog);
        return ResponseEntity.created(new URI("/api/autonomous-car/routes/travel-log/" + result.getId()))
                .body(result);
    }

    @PutMapping("/travel-log/{id}")
    ResponseEntity<TravelLog> updateTravelLog(@RequestBody TravelLog travelLog) {
        TravelLog result = travelLogRepository.save(travelLog);
        return ResponseEntity.ok().body(result);
    }
}