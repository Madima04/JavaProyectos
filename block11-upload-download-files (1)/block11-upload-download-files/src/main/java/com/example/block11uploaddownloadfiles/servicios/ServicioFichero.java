package com.example.block11uploaddownloadfiles.servicios;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Date;
@RestController
public class ServicioFichero implements InterfaceServicioFichero {

    private static long contador = 1;

    public long generarIdUnico() {
        return contador++;
    }
    public Date GenenrarTiempoAhora(){
        LocalTime tiempo = LocalTime.now();
        Date hora = new Date(tiempo.getHour(),tiempo.getMinute(),tiempo.getSecond());
        return hora;
    }
}
