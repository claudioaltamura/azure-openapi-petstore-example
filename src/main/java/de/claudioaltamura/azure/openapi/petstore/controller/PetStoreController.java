package de.claudioaltamura.azure.openapi.petstore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import de.claudioaltamura.azure.openapi.petstore.api.DefaultApi;
import de.claudioaltamura.azure.openapi.petstore.model.NewPet;
import de.claudioaltamura.azure.openapi.petstore.model.Pet;
import jakarta.validation.Valid;

@RestController
public class PetStoreController implements DefaultApi {

    @Override
    public ResponseEntity<Pet> addPet(@Valid NewPet newPet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPet'");
    }

    @Override
    public ResponseEntity<Void> deletePet(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePet'");
    }

    @Override
    public ResponseEntity<Pet> findPetById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPetById'");
    }

    @Override
    public ResponseEntity<List<Pet>> findPets(@Valid List<String> tags, @Valid Integer limit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPets'");
    }
    
}
