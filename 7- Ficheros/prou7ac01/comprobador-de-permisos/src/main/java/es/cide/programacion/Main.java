package es.cide.programacion;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero o directorio: ");
        String nom = sc.nextLine();

        File f = new File(nom);

        if (f.exists()) {
            if (f.isFile()) {
                System.out.println("Es un fichero.");
            } else if (f.isDirectory()) {
                System.out.println("Es un directorio.");
            }

            System.out.println("Permiso de lectura: " + f.canRead());
            System.out.println("Permiso de escritura: " + f.canWrite());
            System.out.println("Ruta absoluta: " + f.getAbsolutePath());
        } else {
            System.out.println("No existe.");
        }
        sc.close();
    }
}