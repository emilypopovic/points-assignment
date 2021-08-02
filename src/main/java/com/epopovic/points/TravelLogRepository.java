package com.epopovic.points;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelLogRepository extends JpaRepository<TravelLog, Long> {
    TravelLog findById(String id);
}
