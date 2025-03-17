package org.kafka.consumer.repository;

import org.kafka.consumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WikiMediaRepository extends JpaRepository<WikimediaData, Long> {
    // Additional query methods (if any) can be defined here
}