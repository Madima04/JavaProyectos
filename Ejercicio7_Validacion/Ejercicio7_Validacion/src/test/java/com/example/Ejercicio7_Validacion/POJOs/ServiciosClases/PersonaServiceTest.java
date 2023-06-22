package com.example.Ejercicio7_Validacion.POJOs.ServiciosClases;

import com.example.Ejercicio7_Validacion.Controladores.ControladorPersona;
import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Ejercicio7_Validacion.RepositorioClases.PersonaRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {

    @Mock
    private PersonaRepository repository;

    @InjectMocks
    private PersonaService personaService;

    /**
     * Method under test: {@link PersonaService#addPersonaService(PersonaImput)}
     */
    @Test
    void testAddPersonaService() {

        PersonaImput personaImput = crearPersonaImput();
        Persona persona = crearPersona();
        PersonaOutput personaOutput = new PersonaOutput(persona);
        Mockito.when(repository.save(any())).thenReturn(persona);
        PersonaOutput actualAddPersonaServiceResult = this.personaService.addPersonaService(personaImput);
        actualAddPersonaServiceResult.setId(1);

        assertEquals(personaOutput, actualAddPersonaServiceResult);
    }

    /**
     * Method under test: {@link PersonaService#getOutput(List)}
     */
    @Test
    void testGetOutput() {

        List<Persona> lista = crearListaPersona();
        List<PersonaOutput> actualOutput = this.personaService.getOutput(lista);
        assertEquals(1, actualOutput.size());
    }


    /**
     * Method under test: {@link PersonaService#addPersona(PersonaImput)}
     */
    @Test
    void testAddPersona() {

        PersonaImput personaImput = crearPersonaImput();
        Persona persona = crearPersona();
        PersonaOutput personaOutput = new PersonaOutput(persona);
        Mockito.when(repository.save(any())).thenReturn(persona);
        PersonaOutput actualAddPersonaServiceResult = this.personaService.addPersonaService(personaImput);
        actualAddPersonaServiceResult.setId(1);

        assertEquals(personaOutput, actualAddPersonaServiceResult);

    }

    /**
     * Method under test: {@link PersonaService#getData(HashMap, String)}
     */
    @Test
    void testGetData() {
        HashMap<String, Object> conditions = crearMapaPersona();
        String order = "";
        EntityManager em = Mockito.mock(EntityManager.class);
        personaService.setEm(em);

        Map<Integer, List<Persona>> actualData = this.personaService.getData(conditions, order);
        assertEquals(1, actualData.size());
    }

    private PersonaImput crearPersonaImput(){
        PersonaImput persona = new PersonaImput();
        persona.setId(1);
        persona.setUsuario("john");
        persona.setName("John Doe");
        persona.setPersonal_email("ejemplo@adasdas");
        persona.setCompany_email("dasdasd@jytjy");
        persona.setCity("Buenos Aires");
        persona.setSurname("Doe");
        persona.setImagen_url("https://www.google.com");
        persona.setActive(true);
        persona.setCreated_date(new Date());
        return persona;
    }

    private Persona crearPersona(){
        Persona persona = new Persona();
        persona.setId(1);
        persona.setUsuario("john");
        persona.setName("John Doe");
        persona.setPersonal_email("ejemplo@adasdas");
        persona.setCompany_email("dasdasd@jytjy");
        persona.setCity("Buenos Aires");
        persona.setSurname("Doe");
        persona.setImagen_url("https://www.google.com");
        persona.setActive(true);
        persona.setCreated_date(new Date());
        return persona; //retun de persona
    }

    private PersonaOutput crearPersonaOutput(){
        Persona persona = new Persona();
        persona = crearPersona();
        PersonaOutput personaOutput = new PersonaOutput();
        personaOutput.setUsuario(persona.getUsuario());
        personaOutput.setName(persona.getName());
        personaOutput.setPersonal_email(persona.getPersonal_email());
        personaOutput.setCompany_email(persona.getCompany_email());
        personaOutput.setCity(persona.getCity());
        personaOutput.setId(persona.getId());
        personaOutput.setSurname(persona.getSurname());
        personaOutput.setImagen_url(persona.getImagen_url());
        personaOutput.setActive(persona.getActive());
        return personaOutput;
    }
    private List<Persona> crearListaPersona() {
        Persona persona = crearPersona();
        List<Persona> lista = List.of(persona);
        return lista;
    }

    private HashMap<String, Object> crearMapaPersona() {
        HashMap<String, Object> mapa = new HashMap<>();
        mapa.put("id", 1);
        mapa.put("usuario", "john");
        mapa.put("name", "John Doe");
        mapa.put("personal_email", "ejemplo@adasdas");
        mapa.put("company_email", "dasdasd@jytjy");
        mapa.put("city", "Buenos Aires");
        mapa.put("surname", "Doe");
        mapa.put("imagen_url", "https://www.google.com");
        mapa.put("active", true);
        mapa.put("created_date", new Date());
        return mapa;
    }
}

