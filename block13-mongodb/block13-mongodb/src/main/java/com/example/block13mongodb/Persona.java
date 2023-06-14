package com.example.block13mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    private String id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
    public Persona(String id){
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

    public static List<PersonaOutput> parsePersonaOutputDTO(List<Persona> all) {
        List<PersonaOutput> listpoDTO = new ArrayList<>();
        PersonaOutput poDTO;
        for (Persona persona : all) {
            poDTO = new PersonaOutput();
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
            listpoDTO.add(poDTO);
        }
        return listpoDTO;
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
