package com.example.Ejercicio7_Validacion.POJOs.ServiciosClases;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Input.ProfesorInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.ProfesorOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.POJOs.Profesor;
import com.example.Ejercicio7_Validacion.RepositorioClases.PersonaRepository;
import com.example.Ejercicio7_Validacion.RepositorioClases.ProfesorRepository;
import com.example.Ejercicio7_Validacion.RepositorioClases.StudentRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProfesorServiceTest {
    @MockBean
    private PersonaRepository personaRepository;
    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ProfesorRepository profesorRepository;

    @InjectMocks
    private ProfesorService profesorService;

    /**
     * Method under test: {@link ProfesorService#addProfesorService(ProfesorInput)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddProfesorService() {
        ProfesorInput profesorInput = crearProfesorImput();
        Profesor profesor = crearProfesor(profesorInput);
        ProfesorOutput profesorOutput = ProfesorOutput(profesor);
        profesorOutput.setId(1);
        Mockito.when(profesorRepository.save(any())).thenReturn(profesor);
        ProfesorOutput profesorOutput1 = this.profesorService.addProfesorService(profesorInput);
        profesorOutput1.setId(1);


        assertEquals(profesorOutput, profesorOutput1);
    }

    /**
     * Method under test: {@link ProfesorService#addProfesorService(ProfesorInput)}
     */
    @Test
    void testAddProfesorService2() {
        // Arrange
        // TODO: Populate arranged inputs
        ProfesorInput profesorInput = null;

        // Act
        ProfesorOutput actualAddProfesorServiceResult = this.profesorService.addProfesorService(profesorInput);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link ProfesorService#getProfesorService(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetProfesorService() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: class org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate
        //       at java.util.Optional.map(Optional.java:260)
        //   java.lang.IllegalStateException: Could not load CacheAwareContextLoaderDelegate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
        //       at java.util.Optional.map(Optional.java:260)
        //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]: Constructor threw exception; nested exception is java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
        //       at java.util.Optional.map(Optional.java:260)
        //   java.lang.NoClassDefFoundError: org/springframework/core/io/support/SpringFactoriesLoader$FailureHandler
        //       at java.util.Optional.map(Optional.java:260)
        //   java.lang.ClassNotFoundException: org.springframework.core.io.support.SpringFactoriesLoader$FailureHandler
        //       at java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        profesorService.getProfesorService(1);
    }

    /**
     * Method under test: {@link ProfesorService#getProfesorService(int)}
     */
    @Test
    void testGetProfesorService2() {
        // Arrange
        // TODO: Populate arranged inputs
        int id = 0;

        // Act
        ProfesorOutput actualProfesorService = this.profesorService.getProfesorService(id);

        // Assert
        // TODO: Add assertions on result
    }

    private ProfesorInput crearProfesorImput() {
        ProfesorInput profesorInput = new ProfesorInput();
        profesorInput.setId_profesor(1);
        profesorInput.setId_persona(1);
        profesorInput.setBranch("branch");
        return profesorInput;
    }

    private Profesor crearProfesor(ProfesorInput profesorInput) {
        Profesor profesor = new Profesor();
        profesor.setId_profesor(profesorInput.getId_profesor());
        profesor.setId_persona(profesorInput.getId_persona());
        profesor.setBranch(profesorInput.getBranch());
        return profesor;
    }

    private ProfesorOutput ProfesorOutput(Profesor profesor) {
        return profesor.parseProfesorOutputDTO(profesor);
    }
}

