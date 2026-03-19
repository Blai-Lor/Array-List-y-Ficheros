package es.cide.programacion;

import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirPrimeraFrase {

    public void iniciar() {
        String frase = "Hola, estoy aprendiendo Java!";
        FileOutputStream file = null;

        try {
            //Crea un fichero llamado datos.txt
            file = new FileOutputStream("datos.txt");

            //Esto escribe la frase caracter a caracter los convierte en bytes
            for (int i = 0; i < frase.length(); i++) {
                char c = frase.charAt(i);
                file.write((int) c); 
            }
            System.out.println("Frase escrita en datos.txt");

        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar.");
            }
        }
    }
}
