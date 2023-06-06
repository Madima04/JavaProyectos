package com.example.block11uploaddownloadfiles.controladores;

import com.example.block11uploaddownloadfiles.POJOs.Fichero;
import com.example.block11uploaddownloadfiles.repositorio.FicheroRepository;
import com.example.block11uploaddownloadfiles.servicios.InterfaceServicioFichero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/ficheros")
public class FicheroController {

    @Autowired
    private FicheroRepository ficheroRepository;
    @Autowired
    private InterfaceServicioFichero servicioFichero;

    @PostMapping("/subir")
    @ResponseBody
    public Fichero subirFichero(@RequestParam("archivo") MultipartFile archivo,
                                @RequestParam("categoria") String categoria) throws IOException {
        // Generar ID único
        Long idUnico = servicioFichero.generarIdUnico();

        // Guardar archivo en disco
        String nombreArchivo = StringUtils.cleanPath(archivo.getOriginalFilename()); // Realiza una limpieza o normalización del nombre de archivo obtenido de un objeto evitando errrores en la ruta del archivo
        String rutaArchivo = "c:/tmp/" + nombreArchivo; //Se crea la ruta donde se guardará el archivo
        archivo.transferTo(new File(rutaArchivo)); // Se guarda el archivo en la ruta especificada

        // Insertar en la tabla 'fichero'
        Fichero fichero = new Fichero();
        fichero.setId(idUnico);
        fichero.setNombre(nombreArchivo);
        fichero.setFechaSubida(servicioFichero.GenenrarTiempoAhora());
        fichero.setCategoria(categoria);
        ficheroRepository.save(fichero);

        return fichero;
    }

    @GetMapping("/descargarPorId/{id}")
    public ResponseEntity<Resource> descargarPorId(@PathVariable("id") Long id) {
        // Buscar el archivo en la tabla 'fichero' por ID
        Fichero fichero = ficheroRepository.findById(id).orElse(null);//Si no encuentra el archivo devuelve null
        if (fichero == null) {
            return ResponseEntity.notFound().build();
        }

        // Recuperar la ruta del archivo en disco basado en los datos de la tabla
        String rutaArchivo = "c:/tmp/" + fichero.getNombre();//Se crea la ruta donde se guardará el archivo
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return ResponseEntity.notFound().build();
        }

        // Enviar archivo para descarga
        Resource resource = new FileSystemResource(archivo);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getName() + "\"")
                .body(resource);
    }

    @GetMapping("/descargarPorNombre/{nombre}")
    public ResponseEntity<Resource> descargarPorNombre(@PathVariable("nombre") String nombre) {
        // Buscar el archivo en la tabla 'fichero' por nombre
        Fichero fichero = ficheroRepository.findByNombre(nombre);
        if (fichero == null) {
            return ResponseEntity.notFound().build();
        }

        // Recuperar la ruta del archivo en disco basado en los datos de la tabla
        String rutaArchivo = "c:/tmp/" + fichero.getNombre();
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return ResponseEntity.notFound().build();
        }

        // Enviar archivo para descarga
        Resource resource = new FileSystemResource(archivo);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getName() + "\"")
                .body(resource);
    }
}
