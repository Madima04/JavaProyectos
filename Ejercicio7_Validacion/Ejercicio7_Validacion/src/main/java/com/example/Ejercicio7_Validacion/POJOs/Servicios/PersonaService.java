package com.example.Ejercicio7_Validacion.POJOs.Servicios;

import com.example.Ejercicio7_Validacion.POJOs.Input.PersonaImput;
import com.example.Ejercicio7_Validacion.POJOs.Output.PersonaOutput;
import com.example.Ejercicio7_Validacion.POJOs.Persona;
import com.example.Ejercicio7_Validacion.Repositorio.PersonaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Condition;

@RestController
public class PersonaService implements InterfaceServicioPersona {

    @Autowired
    PersonaRepository personaRepository;
    @PersistenceContext
    EntityManager em;

    public PersonaOutput addPersonaService(PersonaImput persona){
        Persona p = new Persona(persona);
        personaRepository.save(p);
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

    public List<Persona> getData(HashMap<String, Object> conditions){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);// Decimos con que tabla vamos a trabajar (Persona)
        Root<Persona> root = query.from(Persona.class);//Creamos la raiz

        //Condiciones where
        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field, value) -> {
            switch (field){
                case "name":
                    predicates.add(cb.like(root.get(field), "%" + (String) value + "%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field), "%" + (String) value + "%"));
                    break;
                case "usuario":
                    predicates.add(cb.like(root.get(field), "%" + (String) value + "%"));
                    break;
                case "created_date":
                    String dateCondition = (String) conditions.get("created_date");
                    switch (dateCondition){
                        case "before":
                            predicates.add(cb.lessThan(root.get(field), (String) value));
                            break;
                        case "after":
                            predicates.add(cb.greaterThan(root.get(field), (String) value));
                            break;
                        case "equal":
                            predicates.add(cb.equal(root.get(field), (String) value));
                            break;
                    }
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));//Añadimos las condiciones en forma de array de predicados
        return em.createQuery(query).getResultList();//Ejecutamos la query
    }
}

