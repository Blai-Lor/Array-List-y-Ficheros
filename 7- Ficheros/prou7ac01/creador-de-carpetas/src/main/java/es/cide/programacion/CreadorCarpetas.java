package es.cide.programacion;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreadorCarpetas {

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        
        //Pedimos el nombre de la carpeta
        System.out.print("Introduce el nombre de la nueva carpeta: ");
        String nombreCarpeta = sc.nextLine();
        
        //Crear un objeto File para la carpeta
        File carpeta = new File(nombreCarpeta);
        
        if (!carpeta.exists()) {
            boolean creada = carpeta.mkdir(); //Crea la carpeta
            if (creada) {
                System.out.println("Carpeta creada correctamente: " + nombreCarpeta);
            } else {
                System.out.println("No se ha podido crear la carpeta.");
                return; //Sale si no se puede crear la carpeta
            }
        } else {
            System.out.println("La carpeta ya existe.");
        }
        
        //Crea fichero hola.txt dentro de la carpeta
        File fichero = new File(carpeta, "hola.txt");
        try {
            boolean ficheroCreado = fichero.createNewFile();
            if (ficheroCreado) {
                System.out.println("Fichero 'hola.txt' creado correctament dentro " + nombreCarpeta);
            } else {
                System.out.println("El fichero 'hola.txt' ya existe dentro de la carpeta.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
        
        sc.close();
    }
}