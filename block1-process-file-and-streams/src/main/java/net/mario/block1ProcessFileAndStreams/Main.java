package net.mario.block1ProcessFileAndStreams;

import net.mario.block1ProcessFileAndStreams.POJOs.Persona;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static final String URL = String.valueOf(Main.class.getResource("people.csv")).substring(6);

    public static void main(String[] args) throws IOException {

        //System.out.println(toStringListas(sacarMenoresDe(sacarDatosPersona(URL))));
        System.out.println(toStringListas(sacarNoEmpiezaPor(sacarDatosPersona(URL), "A")));
        //System.out.println(toStringListas(sacarEsDeMadrid(sacarMenoresDe(sacarDatosPersona(URL)))));
        //System.out.println(toStringListas(sacarEsDeBarcelona(sacarMenoresDe(sacarDatosPersona(URL)))));

    }

    public static List<Persona> sacarDatosPersona(String direccion) throws IOException {
        List<Persona> listaDePersonas = new ArrayList<Persona>();
        Persona persona;

        BufferedReader br = new BufferedReader(new FileReader(new File(direccion)));

        while (true) {
            String data = br.readLine();
            if (data == null) break;
            try{
            if (!data.matches("^[A-Za-zÁÉÍÓÚáéíóúÜüÑñ ]+:[A-Za-zÁÉÍÓÚáéíóúÜüÑñ ]*:[0-9]*$")) {
                throw new InvalidLineFormatException();}
            }catch (InvalidLineFormatException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
            String[] datos = (data.split(":"));
            if (datos[0].equals("")) continue;
            if (datos.length == 2) {
                persona = new Persona(datos[0], datos[1], -1);
            } else if (datos.length == 3) {
                if (Objects.equals(datos[1], "")) {
                    persona = new Persona(datos[0], " Sin datos ", Integer.parseInt(datos[2]));
                } else {
                    persona = new Persona(datos[0], datos[1], Integer.parseInt(datos[2]));
                }
            } else {
                persona = new Persona(datos[0], "Sin datos", -1);
            }
            listaDePersonas.add(persona);
        }


        return listaDePersonas;
    }

    public static List<Persona> sacarMenoresDe(List<Persona> listaDePersonas) {

        return new ArrayList<>(filtradoPersonasEdad((ArrayList<Persona>) listaDePersonas));

    }

    private static List<Persona> filtradoPersonasEdad(ArrayList<Persona> listaPersonas) {

        return listaPersonas.stream().filter((Persona persona) -> persona.getAge() > 0 && persona.getAge() < 25).collect(Collectors.toList());
    }

    private static List<Persona> filtradoPersonasLetra(ArrayList<Persona> listaPersonas) {

        return listaPersonas.stream().filter((Persona persona) -> !quitarTildes(String.valueOf(persona.getName().charAt(0))).equals("A")).collect(Collectors.toList());
    }

    private static List<Persona> filtradoPersonasCiudadMadrid(ArrayList<Persona> listaPersonas) {
        Optional<Persona> op;
        ArrayList<Persona> personaFiltrada = new ArrayList<>();
        op = listaPersonas.stream().filter((Persona persona) -> (persona.getTown().equals("Madrid"))).findFirst();
        if (op.isPresent()) {
            personaFiltrada.add(op.get());
            return personaFiltrada;
        } else {
            System.out.println("No hay Registros");
            return personaFiltrada;
        }
    }

    private static List<Persona> filtradoPersonasCiudadBarcelona(ArrayList<Persona> listaPersonas) {
        Optional<Persona> op;
        ArrayList<Persona> personaFiltrada = new ArrayList<>();
        op = listaPersonas.stream().filter((Persona persona) -> (persona.getTown().equals("Barcelona"))).findFirst();
        if (op.isPresent()) {
            personaFiltrada.add(op.get());
            return personaFiltrada;
        } else {
            System.out.println("No hay Registros");
            return personaFiltrada;
        }
    }

    public static ArrayList<Persona> sacarNoEmpiezaPor(List<Persona> listaDePersonas, String letraInicio) {

        return new ArrayList<>(filtradoPersonasLetra((ArrayList<Persona>) listaDePersonas));

    }

    public static ArrayList<Persona> sacarEsDeMadrid(List<Persona> listaDePersonas) {

        return new ArrayList<>(filtradoPersonasCiudadMadrid((ArrayList<Persona>) listaDePersonas));

    }

    public static ArrayList<Persona> sacarEsDeBarcelona(List<Persona> listaDePersonas) {

        return new ArrayList<>(filtradoPersonasCiudadBarcelona((ArrayList<Persona>) listaDePersonas));

    }

    private static String quitarTildes(String texto) {
        String original = "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýÿ";
        // Cadena de caracteres ASCII que reemplazarán los originales.
        String ascii = "AAAAAAACEEEEIIIIDNOOOOOOUUUUYBaaaaaaaceeeeiiiionoooooouuuuyy";
        String output = texto;
        for (int i = 0; i < original.length(); i++) {
            // Reemplazamos los caracteres especiales.

            output = output.replace(original.charAt(i), ascii.charAt(i));

        }
        return output;
    }

    private static String toStringListas(List<Persona> listaDePersonas){
        StringBuilder sb = new StringBuilder();
        for (Persona p: listaDePersonas) {
            sb.append(p.toString());
        }
        return sb.toString();
    }

}
