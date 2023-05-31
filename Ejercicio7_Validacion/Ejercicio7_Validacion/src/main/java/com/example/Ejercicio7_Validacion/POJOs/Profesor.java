package com.example.Ejercicio7_Validacion.POJOs;

import com.example.Ejercicio7_Validacion.POJOs.Input.ProfesorInput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Output.ProfesorOutput;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    Integer id_profesor;
    @OneToOne
    @JoinColumn(name="persona_id")
    Persona persona;
    @NotNull
    String branch;

    public Profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public Profesor(ProfesorInput profesorInput, PersonaRepository personaRepository) {
        this.id_profesor = profesorInput.getId_profesor();
        this.persona = personaRepository.findById(profesorInput.getId_persona()).get();
        this.branch = profesorInput.getBranch();
    }

    public ProfesorOutput parsePersonaOutputDTO(Profesor p) {
        ProfesorOutput profesorOutput = new ProfesorOutput();
        profesorOutput.setId_profesor(p.getId_profesor());
        profesorOutput.setPersona(this.persona.parsePersonaOutputDTO(this.persona));
        profesorOutput.setBranch(p.getBranch());
        return profesorOutput;
    }

    public ProfesorOutput parseProfesorOutputDTO(Profesor profesor) {
        ProfesorOutput profesorOutput = new ProfesorOutput();
        profesorOutput.setId_profesor(profesor.getId_profesor());
        profesorOutput.setPersona(this.persona.parsePersonaOutputDTO(this.persona));
        profesorOutput.setBranch(profesor.getBranch());
        return profesorOutput;
    }
}