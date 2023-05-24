package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class Controlador3 {

    @Autowired
    private PersonaRepository personaRepository;

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable(value = "id") long id) {
        Persona aux = new Persona();
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            aux = persona;
            personaRepository.delete(persona);
            return ResponseEntity.ok(aux);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
