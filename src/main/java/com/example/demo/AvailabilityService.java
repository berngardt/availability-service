package com.example.demo;

import com.example.demo.repository.AvailabilityMessageRepository;
import com.example.demo.repository.model.AvailabilityMessage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@Service
public class AvailabilityService {

    private final AvailabilityMessageRepository availabilityMessageRepository;

    public AvailabilityService(AvailabilityMessageRepository availabilityMessageRepository) {
        this.availabilityMessageRepository = availabilityMessageRepository;
    }

    public static final String DEFAULT_MESSAGE = "I will work today!";

    public Mono<String> getAvailabilityMessage(String lang, String time) {
        if (time == null || time.isEmpty()) {
            return Mono.just(DEFAULT_MESSAGE);
        }
        return getMessagesByLanguage(lang).collectList().map(availabilityMessages -> {
            Random rand = new Random();
            AvailabilityMessage availabilityMessage = availabilityMessages.get(rand.nextInt(availabilityMessages.size()));
            return String.format(availabilityMessage.getMessage(), time);
        });
    }

    private Flux<AvailabilityMessage> getMessagesByLanguage(String language) {
        if (language.isEmpty()) return availabilityMessageRepository.findAll();
        else return availabilityMessageRepository.findAllByLang(language);
    }
}
