package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controlador1 {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("/persona")
    public Persona addPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @GetMapping("/personas")
    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }
}
