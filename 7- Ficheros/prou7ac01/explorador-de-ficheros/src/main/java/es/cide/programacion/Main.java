/*
Crea un programa que demani a l'usuari una ruta absoluta d'un directori. El programa ha de:
Comprovar si la ruta realment existeix.
Si existeix, mostrar per pantalla el nom de tots els fitxers i subdirectoris que conté.
*/

package es.cide.programacion;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una ruta absoluta: ");
        String ruta = sc.nextLine();

        File directori = new File(ruta);

        if (directori.exists()) {
            System.out.println("El directorio existe.");
            String[] contingut = directori.list();

            if (contingut != null) {
                for (String nom : contingut) {
                    System.out.println(nom);
                }
            }
        } else {
            System.out.println("La ruta no existe.");
        }
        sc.close();
    }
}