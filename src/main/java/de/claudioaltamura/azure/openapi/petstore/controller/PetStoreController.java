package de.claudioaltamura.azure.openapi.petstore.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

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

    @Override
    public ResponseEntity<Pet> addPet(@Valid NewPet newPet) {
        var tag = newPet.getTag();
        pets.putIfAbsent(tag, new ArrayList<>());
        var petToAdd = Pet.builder().id(id.getAndIncrement()).name(newPet.getName()).tag(tag).build();
        pets.get(tag).add(petToAdd);
        return ResponseEntity.ok(petToAdd);
    }

    @Override
    public ResponseEntity<Void> deletePet(Long id) {
        pets.values()
                .forEach(petList -> petList.removeIf(pet -> id.equals(pet.getId()))
                );
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Pet> findPetById(Long id) {
        var foundPet = pets.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(pet -> id.equals(pet.getId()))
                .findFirst().orElseThrow(IllegalArgumentException::new);
        return ResponseEntity.ok(foundPet);
    }

    @Override
    public ResponseEntity<List<Pet>> findPets(@Valid List<String> tags, @Valid Integer limit) {
        var allPets = new ArrayList<Pet>();
        tags.forEach(tag -> {
            if(pets.containsKey(tag)) {
                allPets.addAll(pets.get(tag));
            }
        });
        return ResponseEntity.ok(allPets);
    }
    
}
