package com.example.Ejercicio7_Validacion.POJOs.Input;

import com.example.Ejercicio7_Validacion.POJOs.Persona;
import lombok.Data;

import java.util.Date;
@Data
public class PersonaImput {

    Integer id;
    String usuario;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Boolean admin;
    Date created_date;
    String imagen_url;
    Date termination_date;
    public Persona parsePersona(PersonaImput persona) {
        return new Persona(persona);
    }
}
