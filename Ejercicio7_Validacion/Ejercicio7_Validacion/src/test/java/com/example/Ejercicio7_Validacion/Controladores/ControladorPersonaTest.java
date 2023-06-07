package com.example.Ejercicio7_Validacion.Controladores;

import com.example.Ejercicio7_Validacion.Excepciones.EntityNotFoundException;
import com.example.Ejercicio7_Validacion.Excepciones.UnprocessableEntityException;
import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.ProfesorOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.Servicios.InterfaceServicioEstudiante;
import com.example.Ejercicio7_Validacion.POJOs.Servicios.InterfaceServicioPersona;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorPersonaTest {

    @Mock
    private PersonaRepository repository;

    @Mock
    private InterfaceServicioEstudiante interfaceServicioEstudiante;

    @Mock
    private InterfaceServicioPersona interfaceServicioPersona;

    @InjectMocks
    private ControladorPersona controladorPersona;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<Persona>());
    }

    @Test
    public void testGetPersona_ValidPersona_ReturnsPersona() throws Exception {
        PersonaImput persona = new PersonaImput();
        Persona persona1 = new Persona();
        PersonaOutput personaOutput = new PersonaOutput();
        List<Persona> personas = new ArrayList<>();
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
        personaOutput.setUsuario(persona.getUsuario());
        personaOutput.setName(persona.getName());
        personaOutput.setPersonal_email(persona.getPersonal_email());
        personaOutput.setCompany_email(persona.getCompany_email());
        personaOutput.setCity(persona.getCity());
        personaOutput.setId(persona.getId());
        personaOutput.setSurname(persona.getSurname());
        personaOutput.setImagen_url(persona.getImagen_url());
        personaOutput.setActive(persona.getActive());
        interfaceServicioPersona.addPersona(persona);
        assertEquals(interfaceServicioPersona.addPersonaService(persona), personaOutput);
    }

    @Test
    public void testGetPersona_NullPersona_ThrowsEntityNotFoundException() {

    }

    @Test
    public void testGetPersona_InvalidUsuarioLength_ThrowsUnprocessableEntityException() {

    }

    @Test
    public void testGetPersona_EmptyName_ThrowsEntityNotFoundException() {

    }

    @Test
    public void testGetId_ExistingId_ReturnsPersona() {

    }

    @Test
    public void testGetId_NonExistingId_ReturnsEntityNotFoundException() {

    }

    @Test
    public void testGetNombre_ExistingNombre_ReturnsPersona() {

    }

    @Test
    public void testGetNombre_NonExistingNombre_ReturnsNotFoundStatus() {

    }

    @Test
    public void testListPersonas_ReturnsListOfPersonas() {

    }

    @Test
    public void testAddPersona_ValidPersona_ReturnsPersonaOutput() {

    }

    @Test
    public void testGetAllPersonas_ReturnsListOfPersonaOutput() {

    }

    @Test
    public void testGetProfesor_ValidId_ReturnsProfesorOutput() {

    }

    @Test
    public void testGetAll_ReturnsListOfPersonaOutput() {

    }

    @Test
    public void testGetSelect_ReturnsListOfPersonaOutput() {

    }
}
