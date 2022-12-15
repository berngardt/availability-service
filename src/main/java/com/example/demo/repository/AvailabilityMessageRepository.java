package com.example.demo.repository;

import com.example.demo.repository.model.AvailabilityMessage;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AvailabilityMessageRepository extends ReactiveMongoRepository<AvailabilityMessage, String> {

    Flux<AvailabilityMessage> findAllByLang(String lang);
}
