package es.cide.programacion;

import java.io.File;
import java.util.Scanner;

public class ComprobadorDePermisos {

    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del archivo o directorio: ");
        String nombre = sc.nextLine();

        File file = new File(nombre);

        if (file.exists()) {
            System.out.println("--- Fichero ---");
            
            //Indica si es un fichero o un directorio
            System.out.println("Es fichero: " + (file.isFile() ? "Sí" : "No"));
            System.out.println("Es directorio: " + (file.isDirectory() ? "Sí" : "No"));

            //Indica si tenemos permisos de lectura i de escritura
            System.out.println("Permiso de lectura: " + (file.canRead() ? "Sí" : "No"));
            System.out.println("Permiso de escritura: " + (file.canWrite() ? "Sí" : "No"));

            //Muestra su ruta absoluta completa
            System.out.println("Ruta absoluta: " + file.getAbsolutePath());
        } else {
            System.out.println("El elemento no existe.");
        }
    }
}
