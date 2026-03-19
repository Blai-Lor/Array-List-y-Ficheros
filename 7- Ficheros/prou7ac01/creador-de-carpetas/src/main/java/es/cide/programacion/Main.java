/* 
Fas servir la classe File per crear una estructura de treball. El programa ha de:
Demanar el nom d'una nova carpeta.
Crear-la físicament al disc dur.
Dins d'aquesta carpeta, crear un fitxer buit anomenat hola.txt.
*/

package es.cide.programacion;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la nueva carpeta: ");
        String nomCarpeta = sc.nextLine();

        File carpeta = new File(nomCarpeta);

        if (carpeta.mkdir()) {
            System.out.println("Carpeta creada.");

            File fitxer = new File(carpeta, "hola.txt");
            try {
                if (fitxer.createNewFile()) {
                    System.out.println("Fichero hola.txt creado.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el fichero.");
            }
        } else {
            System.out.println("No se ha podido crear la carpeta.");
        }
        sc.close();
    }
}