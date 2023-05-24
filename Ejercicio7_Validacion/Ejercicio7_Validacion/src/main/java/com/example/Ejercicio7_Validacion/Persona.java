package com.example.Ejercicio7_Validacion;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_persona")
    Integer id;
    @Size(min = 6, max = 10, message = "El nombre debe contener entre 6 y 10 caracteres")
    @NotNull
    String usuario;
    @NotNull
    String password;
    @NotNull
    String name;
    String surname;
    @NotNull
    String company_email;
    @NotNull
    String personal_email;
    @NotNull
    String city;
    @NotNull
    Boolean active;
    @NotNull
    Date created_date;
    String imagen_url;
    Date termination_date;

}
