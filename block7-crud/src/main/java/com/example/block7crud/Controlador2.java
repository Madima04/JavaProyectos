package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class Controlador2 {

    @Autowired
    private PersonaRepository personaRepository;

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable(value = "id") long id, @RequestBody Persona personaDetails) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent() && personaDetails.getNombre() != null && personaDetails.getPoblacion() != null && personaDetails.getEdad() != 0) {
            Persona persona = personaOptional.get();
            persona.setNombre(personaDetails.getNombre());
            persona.setEdad(personaDetails.getEdad());
            persona.setPoblacion(personaDetails.getPoblacion());
            return ResponseEntity.ok(personaRepository.save(persona));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
