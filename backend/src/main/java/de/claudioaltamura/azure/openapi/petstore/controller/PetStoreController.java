package de.claudioaltamura.azure.openapi.petstore.controller;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import de.claudioaltamura.azure.openapi.petstore.api.DefaultApi;
import de.claudioaltamura.azure.openapi.petstore.model.NewPet;
import de.claudioaltamura.azure.openapi.petstore.model.Pet;
import jakarta.validation.Valid;

@RestController
public class PetStoreController implements DefaultApi {

    private final Map<String, List<Pet>> pets = new ConcurrentHashMap<>();

    private final AtomicLong id = new AtomicLong(1);

    private final SlowAndFaultyServer slowAndFaultyServer = new SlowAndFaultyServer();

    @Override
    public ResponseEntity<Pet> addPet(@Valid NewPet newPet) {
        slowAndFaultyServer.addSlowOrFaultyServerBehaviour();
        var tag = newPet.getTag();
        pets.putIfAbsent(tag, new ArrayList<>());
        var petToAdd = Pet.builder().id(id.getAndIncrement()).name(newPet.getName()).tag(tag).build();
        pets.get(tag).add(petToAdd);
        return ResponseEntity.ok(petToAdd);
    }

    @Override
    public ResponseEntity<Void> deletePet(Long id) {
        slowAndFaultyServer.addSlowOrFaultyServerBehaviour();
        pets.values()
                .forEach(petList -> petList.removeIf(pet -> id.equals(pet.getId()))
                );
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Pet> findPetById(Long id) {
        slowAndFaultyServer.addSlowOrFaultyServerBehaviour();
        var foundPet = pets.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(pet -> id.equals(pet.getId()))
                .findFirst().orElseThrow(IllegalArgumentException::new);
        return ResponseEntity.ok(foundPet);
    }

    @Override
    public ResponseEntity<List<Pet>> findPets(@Valid List<String> tags, @Valid Integer limit) {
        slowAndFaultyServer.addSlowOrFaultyServerBehaviour();
        var allPets = new ArrayList<Pet>();
        tags.forEach(tag -> {
            if(pets.containsKey(tag)) {
                allPets.addAll(pets.get(tag));
            }
        });
        return ResponseEntity.ok(allPets);
    }

    private static class SlowAndFaultyServer {

        private static final Logger log = LoggerFactory.getLogger(SlowAndFaultyServer.class);

        private int getRandomNumber() {
            return new Random().nextInt(10);
        }

        private boolean isFaulty() {
            var randomPercentage = getRandomNumber();
            log.info("fault percentage: '{}'", randomPercentage);
            return isFaultyServer(randomPercentage);
        }

        private boolean isFaultyServer(int percentage) {
            var ten_percentage = 1;
            return percentage <= ten_percentage;
        }

        private int getLatency() {
            final int latencyInMs = 200;
            var randomPercentage = getRandomNumber();
            log.info("slow percentage: '{}'", randomPercentage);
            return isSlow(randomPercentage) ? latencyInMs : 0;
        }

        private boolean isSlow(int percentage) {
            var sixty_percent = 6;
            return percentage >= sixty_percent;
        }

        public void addSlowOrFaultyServerBehaviour() {
            if (isFaulty()) {
                log.info("server is faulty");
                throw new RuntimeException();
            } else {
                log.info("server is normal");
            }
            var latency = getLatency();
            if (latency > 0) {
                try {
                    log.info("slow server: adding '{}'", latency);
                    TimeUnit.MILLISECONDS.sleep(latency);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                log.info("server is running fast...");
            }

        }
    }
}