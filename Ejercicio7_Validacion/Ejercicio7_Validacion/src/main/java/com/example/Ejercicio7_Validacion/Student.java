package com.example.Ejercicio7_Validacion;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_string;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @NotNull
    int num_hours_week;
    @OneToOne
    @JoinColumn(name="id_profesor")
    Profesor profesor;
    @NotNull
    String branch;

}