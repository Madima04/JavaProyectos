package com.example.Ejercicio7_Validacion.Controladores;

import com.example.Ejercicio7_Validacion.Excepciones.EntityNotFoundException;
import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.ProfesorOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.Servicios.InterfaceServicioEstudiante;
import com.example.Ejercicio7_Validacion.POJOs.Servicios.InterfaceServicioPersona;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import com.example.Ejercicio7_Validacion.Excepciones.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ControladorPersona {

    @Autowired
    InterfaceServicioPersona interfaceServicioPersona;
    @Autowired
    InterfaceServicioEstudiante interfaceServicioEstudiante;
    @Autowired
    PersonaRepository repository;
    RestTemplate restTemplate;

    @PostMapping("/addPersona")
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
        if (persona.getPersonal_email() != null && persona.getPersonal_email().contains(persona.getName())) {
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
        for (Persona persona : repository.findAll()) {
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

    @PostMapping("/addperson")
    @ResponseBody
    public PersonaOutput addPersona(@RequestBody PersonaImput persona) {
        return interfaceServicioEstudiante.addPersonaService(persona);
    }

    @PostMapping("/getall")
    @ResponseBody
    public List<PersonaOutput> getAllPersonas() {
        return interfaceServicioEstudiante.getAllPersonasService();
    }

    @GetMapping("/getProfesor/{id}")
    public ProfesorOutput getProfesor(@PathVariable int id) {
        restTemplate = new RestTemplate();
        ProfesorOutput profesor = restTemplate.getForObject("http://localhost:8080/profesor/get/" + id, ProfesorOutput.class);
        return profesor;
    }

    @GetMapping("/getall")
    public List<PersonaOutput> getAll() {
        List<PersonaOutput> lista = interfaceServicioEstudiante.getAllPersonasService();
        return lista;
    }

    @GetMapping("/getSelect")
    public List<PersonaOutput> getSelect(@RequestParam(required = false, name = "usuario") String usuario,
                                         @RequestParam(required = false, name = "name") String name,
                                         @RequestParam(required = false, name = "surname") String surname,
                                         @RequestParam(required = false, name = "created_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date created_date,
                                         @RequestParam(required = false, name = "dateCondition") String dateCondition,
                                         @RequestParam(required = false, name = "ordenadoPor") String ordenadoPor,
                                        @RequestParam(required = false, name = "pagina") Integer pagina) {
        Map<Integer, List<Persona>> dataPaginas;
        HashMap<String, Object> data = new HashMap<>();
        List<Persona> lista;
        List<PersonaOutput> listaOutput = new ArrayList<>();
        PersonaOutput personaOutput;
        if (pagina == null || pagina < 0) {
            pagina = 0;
        }
        if (ordenadoPor == null || ordenadoPor.length() == 0 || !ordenadoPor.equalsIgnoreCase("usuario") || !ordenadoPor.equalsIgnoreCase("name")){
            ordenadoPor = "id";
        }
        if (dateCondition == null) {
            dateCondition = "equals";
        }
        if (usuario != null) {
            data.put("usuario", usuario);
        }
        if (name != null) {
            data.put("name", name);
        }
        if (surname != null) {
            data.put("surname", surname);
        }
        if (created_date != null) {
            if (dateCondition == "before") {
                data.put("before", created_date);
                if (dateCondition == "after") {
                    data.put("after", created_date);
                }
                if (dateCondition == "equals") {
                    data.put("equals", created_date);
                }
            }
        }

        dataPaginas = interfaceServicioPersona.getData(data, ordenadoPor);
        lista = dataPaginas.get(pagina);
        for (Persona persona : lista) {
            personaOutput = new PersonaOutput();
            personaOutput.setId(persona.getId());
            personaOutput.setUsuario(persona.getUsuario());
            personaOutput.setName(persona.getName());
            personaOutput.setSurname(persona.getSurname());
            personaOutput.setCompany_email(persona.getCompany_email());
            personaOutput.setPersonal_email(persona.getPersonal_email());
            personaOutput.setCity(persona.getCity());
            personaOutput.setActive(persona.getActive());
            personaOutput.setCreated_date(persona.getCreated_date());
            listaOutput.add(personaOutput);
        }
        return listaOutput;
    }
}

