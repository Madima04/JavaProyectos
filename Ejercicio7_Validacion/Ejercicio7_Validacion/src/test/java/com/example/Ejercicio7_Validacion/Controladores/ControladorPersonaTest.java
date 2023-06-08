package com.example.Ejercicio7_Validacion.Controladores;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.ServiciosClases.InterfaceServicioPersona;
import com.example.Ejercicio7_Validacion.RepositorioClases.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ControladorPersonaTest {

    @Mock
    private PersonaRepository repository;

    @Mock
    private InterfaceServicioPersona interfaceServicioPersona;

    @InjectMocks
    private ControladorPersona controladorPersona;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.initMocks(this);
        //Mockito.when(repository.findAll()).thenReturn(new ArrayList<Persona>());
    }

    @Test
    public void testGetPersona_ValidPersona_ReturnsPersona() throws Exception {
        Persona persona1 = crearPersona();
        Mockito.when(repository.save(any())).thenReturn(persona1);
        PersonaOutput personaout2 = new PersonaOutput(persona1);
        Mockito.when(repository.save(any())).thenReturn(persona1);
        PersonaOutput personaOut = controladorPersona.getPersona(persona1);

        assertEquals(personaOut, personaout2);
    }

    @Test
    public void testGetId_ExistingId_ReturnsPersona() {
        Object optional;
        Persona persona1 = crearPersona();
        Mockito.when(repository.save(any())).thenReturn(persona1);
        PersonaOutput personaout2 = new PersonaOutput(persona1);
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(persona1));
        optional = controladorPersona.getId(persona1.getId());

        assertEquals(optional, personaout2);
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
        return persona;
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
}
