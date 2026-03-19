package es.cide.programacion;

import java.io.File;
import java.util.Scanner;

public class ExploradorFicheros {

    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la ruta absoluta del directorio:");
        String ruta = sc.nextLine();

        File directorio = new File(ruta); //Creamos un objeto File con la ruta

        if (directorio.exists() && directorio.isDirectory()) { //Comprobamos si la ruta existe y es un directorio
            System.out.println("El directorio existe y contiene:");
            String[] contenido = directorio.list(); //Obtenemos el contenido del directorio como un array de Strings
            if (contenido != null) { //Comprobamos que el contenido no sea null
                for (String nombre : contenido) { //Repite sobre el contenido del directorio
                    System.out.println(nombre); //Imprimimos el nombre de cada archivo o subdirectorio que contiene el directorio, el contenido que hay
                }
            } else { //Si no se puede leer el contenido
                System.out.println("No se puede leer el contenido del directorio.");
            }
        } else { //Si ponemos algo que no sea la ruta
            System.out.println("La ruta indicada no existe o no es un directorio.");
        }

        sc.close();
    }
}
