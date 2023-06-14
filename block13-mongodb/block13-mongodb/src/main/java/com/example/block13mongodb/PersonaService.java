package com.example.block13mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonaService implements InterfaceServicioPersona {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Map<Integer, List<Persona>> getData(HashMap<String, Object> conditions, String order) {
        return null;
    }

    public PersonaOutput addPersonaService(PersonaImput persona){
        Persona p = new Persona(persona);
        mongoTemplate.save(p);
        return p.parsePersonaOutputDTO(p);
    }

    @Override
    public List<PersonaOutput> getOutput(List<Persona> lista) {
        List<PersonaOutput> listaOutput = new ArrayList<>();
        for (Persona p : lista){
            listaOutput.add(p.parsePersonaOutputDTO(p));
        }
        return listaOutput;
    }

    @Override
    public void addPersona(PersonaImput persona) {
        Persona p = new Persona(persona);
        mongoTemplate.save(p);
    }


    private Map<Integer, List<Persona>> divirEnPaginasDeDiez(List<Persona> lista){
        Map<Integer, List<Persona>> mapa = new HashMap<>();
        int i = 0;
        int j = 0;
        List<Persona> listaAux = new ArrayList<>();
        for (Persona p : lista){
            if (i == 10){
                mapa.put(j, listaAux);
                listaAux = new ArrayList<>();
                i = 0;
                j++;
            }
            listaAux.add(p);
            i++;
        }
        mapa.put(j, listaAux);
        return mapa;
    }

}

