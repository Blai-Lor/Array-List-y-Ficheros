package es.cide.programacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            File fitxer = new File("datos.txt");
            fis = new FileInputStream(fitxer);

            int contingut;
            int comptador = 0;

            while ((contingut = fis.read()) != -1) {
                System.out.print((char) contingut);
                comptador++;
            }

            System.out.println("\nBytes totals: " + comptador);
            System.out.println("Medida con length(): " + fitxer.length());
        } catch (IOException e) {
            System.out.println("Error de lectura.");
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero.");
            }
        }
    }
}