package com.example.block6personcontrollers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiciosListadoDeCiudades {

    private List<Ciudad> listaCiudades;
    public ServiciosListadoDeCiudades() {listaCiudades = new ArrayList<>();}
    public void addCiudad(Ciudad ciudad) {
        listaCiudades.add(ciudad);
    }

    public List<Ciudad> getCiudades() {
         return listaCiudades;
    }
}
