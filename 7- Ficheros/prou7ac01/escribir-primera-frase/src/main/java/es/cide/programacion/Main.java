/*
Utilitzant la classe FileOutputStream, crea un programa que:
Crei un fitxer anomenat dades.txt.
Escrigui la frase "Hola, estic aprenent Java!" caràcter a caràcter (convertint-los a bytes).
Important: No oblidis tancar el flux en el bloc finally.
*/

package es.cide.programacion;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("datos.txt");
            String text = "Hola, estoy aprendiendo Java!";

            for (int i = 0; i < text.length(); i++) {
                fos.write((byte) text.charAt(i));
            }

            System.out.println("Texto escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error de escritura.");
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero.");
            }
        }
    }
}