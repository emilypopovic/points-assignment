package com.epopovic.points;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class DatabaseLoader implements CommandLineRunner {

//    private final RouteObjectRepository routeObjectRepository;
//
//    public DatabaseLoader(RouteObjectRepository routeObjectRepository) {
//        this.routeObjectRepository = routeObjectRepository;
//    }

    @Override
    public void run(String... strings) {
        //populate the repo with travel logs
//        this.travelLogRepository.save(new RouteObject("1", "a", 0));
//        this.travelLogRepository.save(new RouteObject("2", "b", 1));
//        this.travelLogRepository.save(new RouteObject("3", "c", 2));
//
//        RouteObject travelLog = this.travelLogRepository.findById("1");
//        this.travelLogRepository.save(travelLog);
    }
}
