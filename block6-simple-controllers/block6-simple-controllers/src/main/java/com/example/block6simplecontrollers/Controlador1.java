package com.example.block6simplecontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controlador1 {
    @ResponseBody
    @GetMapping("/user/{nombre}")
    public String saludar(@PathVariable String nombre) {
        return "hola " + nombre;
    }

    @ResponseBody
    @PostMapping("/useradd")
    public Persona añadirUsuarioMasUnAño(@RequestBody Persona user) {
        user.setEdad(user.getEdad() + 1);
        return user;
    }
}
