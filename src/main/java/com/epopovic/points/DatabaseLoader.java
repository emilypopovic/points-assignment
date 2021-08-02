package com.epopovic.points;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
class DatabaseLoader implements CommandLineRunner {

    private final TravelLogRepository travelLogRepository;

    public DatabaseLoader(TravelLogRepository travelLogRepository) {
        this.travelLogRepository = travelLogRepository;
    }

    @Override
    public void run(String... strings) {
        //populate the repo with travel logs
        this.travelLogRepository.save(new TravelLog("1", "a", 0));
        this.travelLogRepository.save(new TravelLog("2", "b", 1));
        this.travelLogRepository.save(new TravelLog("3", "c", 2));

        TravelLog travelLog = this.travelLogRepository.findById("1");
        this.travelLogRepository.save(travelLog);

        this.travelLogRepository.findAll().forEach(System.out::println);
    }
}
