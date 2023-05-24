package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class Controlador4 {
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable(value = "id") long id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent() && personaOptional.get().getNombre() != null && personaOptional.get().getPoblacion() != null && personaOptional.get().getEdad() != 0) {
            return ResponseEntity.ok(personaOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarNombre/{nombre}")
    public ResponseEntity<ArrayList<Persona>> updatePersonaNombre(@PathVariable(value = "nombre") String nombre) {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        Optional<Persona> personaOptional;
        for (int i = 0; i < personaRepository.findAll().size() + 1; i++) {
            personaOptional = personaRepository.findById((long) i);
            if (personaOptional.isPresent() && personaOptional.get().getNombre().equals(nombre)) {
                personas.add(personaOptional.get());
            }
        }
        return ResponseEntity.ok(personas);
    }
}

