package es.cide.programacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LecturaContadorBytes {

    public void iniciar() {
        FileInputStream files = null;
        try {
            //Abre el fichero datos.txt con un FileInputStream
            File archivo = new File("datos.txt");
            files = new FileInputStream(archivo);

            int byteLeido;
            System.out.print("Este es el contenido del archivo: ");
            
            //Lee todo el contenido y lo muestra por consola
            while ((byteLeido = files.read()) != -1) {
                System.out.print((char) byteLeido);
            }

            //En el final, dice cuantos bytes totales ocupa el fitxer usant length()
            System.out.println("\nTotal de bytes: " + archivo.length());

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            try {
                if (files != null) files.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}