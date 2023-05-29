package com.example.Ejercicio7_Validacion.POJOs.Output;

import com.example.Ejercicio7_Validacion.POJOs.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutput {

    Integer id;
    String usuario;
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
