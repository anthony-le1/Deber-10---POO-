package Archivo;

import Formulario.Persistible;
import Persona.Persona;
import Excepcion.FormularioException;
import java.io.*;
import java.util.regex.Pattern;

public class Archivo implements Persistible<Persona> {

    private final String NOMBRE_ARCHIVO = "hoja_vida.txt";
    private final String DELIMITADOR = "---"; // Separador para los campos de datos

    @Override
    public void guardar(Persona p) throws FormularioException {
        try (FileWriter fw = new FileWriter(NOMBRE_ARCHIVO)) {


            String lineaDatos =
                    p.getCedula() + DELIMITADOR +
                            p.getNombre() + DELIMITADOR +
                            p.getEdad() + DELIMITADOR +
                            p.getDireccion() + DELIMITADOR +
                            p.getCorreo() + DELIMITADOR +
                            p.getTelefono() + DELIMITADOR +
                            p.getGenero() + DELIMITADOR +
                            p.getPerfil() + DELIMITADOR +
                            p.getFormacion() + DELIMITADOR +
                            p.getExperiencia() + DELIMITADOR +
                            p.getCompetencias() + DELIMITADOR +
                            p.getIdiomas();

            fw.write(lineaDatos);
        } catch (IOException e) {
            throw new FormularioException("Error al guardar el archivo .txt: " + e.getMessage());
        }
    }


    @Override
    public Persona mostrar() throws FormularioException {
        // Usamos BufferedReader para leer la línea de texto
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {

            String linea = br.readLine();
            if (linea == null) {
                throw new FormularioException("Aún no se ha guardado ninguna Hoja de Vida.");
            }

            String[] campos = linea.split(Pattern.quote(DELIMITADOR));

            if (campos.length < 12) {
                throw new FormularioException("Error de formato: faltan datos en el archivo .txt.");
            }

            int edad = Integer.parseInt(campos[2]);

            Persona p = new Persona(
                    campos[0],      // Cédula (String)
                    campos[1],      // Nombre (String)
                    edad,           // Edad (int)
                    campos[3],      // Dirección (String)
                    campos[4],      // Correo (String)
                    campos[5],      // Teléfono (String)
                    campos[6],      // Género (String)
                    campos[7],      // Perfil (String)
                    campos[8],      // Formación (String)
                    campos[9],      // Experiencia (String)
                    campos[10],     // Competencias (String)
                    campos[11]      // Idiomas (String)
            );

            return p;

        } catch (FileNotFoundException e) {
            throw new FormularioException("El archivo hoja_vida.txt no existe.");
        } catch (IOException e) {
            throw new FormularioException("Error de I/O al leer el archivo .txt.");
        } catch (NumberFormatException e) {
            throw new FormularioException("Error de formato: La Edad guardada no es un número.");
        }
    }
}

