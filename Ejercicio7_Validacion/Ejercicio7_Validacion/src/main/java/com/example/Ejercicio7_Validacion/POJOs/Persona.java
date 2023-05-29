package com.example.Ejercicio7_Validacion.POJOs;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
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
    public Persona(int id){
        this.id = id;
    }

    public Persona (PersonaImput personaInputDTO) {
        this.usuario = personaInputDTO.getUsuario();
        this.password = personaInputDTO.getPassword();
        this.name = personaInputDTO.getName();
        this.surname = personaInputDTO.getSurname();
        this.company_email = personaInputDTO.getCompany_email();
        this.personal_email = personaInputDTO.getPersonal_email();
        this.city = personaInputDTO.getCity();
        this.active = personaInputDTO.getActive();
        this.created_date = personaInputDTO.getCreated_date();
        this.imagen_url = personaInputDTO.getImagen_url();
        this.termination_date = personaInputDTO.getTermination_date();
    }

    public PersonaOutput parsePersonaOutputDTO(Persona persona) {
        PersonaOutput poDTO = new PersonaOutput();
        poDTO.setId(persona.getId());
        poDTO.setUsuario(persona.getUsuario());
        poDTO.setName(persona.getName());
        poDTO.setSurname(persona.getSurname());
        poDTO.setCompany_email(persona.getCompany_email());
        poDTO.setPersonal_email(persona.getPersonal_email());
        poDTO.setCity(persona.getCity());
        poDTO.setActive(persona.getActive());
        poDTO.setCreated_date(persona.getCreated_date());
        poDTO.setImagen_url(persona.getImagen_url());
        poDTO.setTermination_date(persona.getTermination_date());
        return poDTO;
    }
}
