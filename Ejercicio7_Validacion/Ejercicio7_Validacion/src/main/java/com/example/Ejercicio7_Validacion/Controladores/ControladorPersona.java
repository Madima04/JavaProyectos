package com.example.Ejercicio7_Validacion.Controladores;

import com.example.Ejercicio7_Validacion.Excepciones.EntityNotFoundException;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import com.example.Ejercicio7_Validacion.Excepciones.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControladorPersona {

    @Autowired
    private PersonaRepository repository;
    @PostMapping("/persona")
    public Persona getPersona(@RequestBody Persona persona) throws Exception {
        Optional<Persona> personaOptional = Optional.ofNullable(persona);
        if (!personaOptional.isPresent()) {
            throw new EntityNotFoundException("Usuario no puede ser nulo");
        }
        if (persona.getUsuario().length() >= 10 && persona.getUsuario().length() <= 6) {
            throw new UnprocessableEntityException("Longitud de usuario no puede ser superior a 10 caracteres");
        }
        if (persona.getName() != null && persona.getName().length() == 0) {
            throw new EntityNotFoundException("El nombre no puede ser nulo");
        }
        if (persona.getPassword() != null && persona.getPassword().length() < 8 && persona.getPassword().length() > 0) {
            throw new UnprocessableEntityException("Longitud de password no puede ser inferior a 8 caracteres");
        }
        if (persona.getCompany_email() != null && persona.getCompany_email().contains(persona.getName())) {
            throw new EntityNotFoundException("El email de la empresa no puede contener el nombre de usuario");
        }
        if (persona.getPersonal_email() != null &&persona.getPersonal_email().contains(persona.getName())) {
            throw new EntityNotFoundException("El email personal no puede contener el nombre de usuario");
        }
        if (persona.getPersonal_email().contains(persona.getCompany_email())) {
            throw new EntityNotFoundException("El email personal no puede contener el email de la empresa");
        }
        if (persona.getCity() != null && persona.getCity().length() < 0) {
            throw new EntityNotFoundException("Longitud de ciudad no puede ser inferior a 3 caracteres");
        }
        if (persona.getActive() == null) {
            throw new EntityNotFoundException("El campo active no puede ser nulo");
        }
        if (persona.getCreated_date() == null) {
            throw new EntityNotFoundException("El campo created_date no puede ser nulo");
        }
        return repository.save(persona);
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public Object getId(@PathVariable Integer id) {
        Optional<Persona> personaOptional = repository.findById(id);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            return ResponseEntity.ok(persona);
        } else {
            return new EntityNotFoundException("No se ha encontrado la persona con id: " + id);
        }
    }

    @GetMapping("/{nombre}")
    @ResponseBody
    public ResponseEntity<Object> getNombre(@PathVariable String nombre) {

        Persona p = null;
        for (Persona persona: repository.findAll()) {
            if (persona.getName().equals(nombre)) {
                p = persona;
            }
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/mostrar")
    @ResponseBody
    public List<Persona> listPersonas() {
        return repository.findAll();
    }

}
