package com.example.Ejercicio7_Validacion.Controladores;

import com.example.Ejercicio7_Validacion.POJOs.Output.*;
import com.example.Ejercicio7_Validacion.POJOs.Input.*;
import com.example.Ejercicio7_Validacion.POJOs.ServiciosClases.InterfaceServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/escuela")
public class ControladorEstudiante {

    @Autowired
    InterfaceServicioEstudiante interfaceServicioEstudiante;

    @PostMapping("/addStudent")
    @ResponseBody
    public StudentOutputSimple addStudent(@RequestBody StudentInput student) throws Exception {
        return interfaceServicioEstudiante.addStudentService(student);
    }

    @GetMapping("/findStudent/{id}")
    public Object getId(@PathVariable Integer id, @RequestParam(value = "type", defaultValue = "simple") String type) {
        return interfaceServicioEstudiante.getIdService(id, type);
    }

    @PutMapping("/updateStudent/{id}")
    public Object setStudent(@PathVariable Integer id, @RequestBody StudentInput studentInput){
        return interfaceServicioEstudiante.setStudentService(id, studentInput);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public Object deleteStudent(@PathVariable Integer id){
        return interfaceServicioEstudiante.deleteStudent(id);
    }
}
