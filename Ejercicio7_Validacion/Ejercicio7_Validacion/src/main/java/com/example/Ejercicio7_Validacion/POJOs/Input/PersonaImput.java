package com.example.Ejercicio7_Validacion.POJOs.Input;

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
    Date created_date;
    String imagen_url;
    Date termination_date;


}