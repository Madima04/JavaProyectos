package com.example.Ejercicio7_Validacion;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante_asignatura")
public class Estudiante_asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    Integer id_asignatura;
    @OneToMany
    List<Student> estudiantes;
    String asignatura;
    @NotNull
    Date initial_date;
    Date finish_date;

}
