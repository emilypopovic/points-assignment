package com.epopovic.points;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/autonomous-car/routes")
class ClientController {

    private final Logger log = LoggerFactory.getLogger(ClientController.class);
    private final TravelLogRepository travelLogRepository;

    public ClientController(TravelLogRepository travelLogRepository) {
        this.travelLogRepository = travelLogRepository;
    }

    @GetMapping("/travel-logs")
    Collection<TravelLog> getTravelLogs() {
        log.info("Request to update travel logs");
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

    @DeleteMapping("/travel-log/{id}")
    public ResponseEntity<?> deleteTravelLog(@PathVariable Long id) {
        travelLogRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}