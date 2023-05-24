package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador")
public class Controlador {
    private final Persona Bean1;
    private final Persona Bean2;
    private final Persona Bean3;

    public Controlador(@Qualifier("bean1") Persona Bean1, @Qualifier("bean2") Persona Bean2, @Qualifier("bean3") Persona Bean3) {
        this.Bean1 = Bean1;
        this.Bean2 = Bean2;
        this.Bean3 = Bean3;
    }

    @PostMapping("/bean/{bean}")
    public Persona infoPersonaBean(@PathVariable String bean) {
        switch (bean) {
            case "bean1":
                return Bean1;
            case "bean2":
                return Bean2;
            case "bean3":
                return Bean3;
            default:
                return null;
        }
    }
}

