package com.example.block11uploaddownloadfiles.repositorio;

import com.example.block11uploaddownloadfiles.POJOs.Fichero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheroRepository extends JpaRepository<Fichero, Long> {
    Fichero findByNombre(String nombre);
}

