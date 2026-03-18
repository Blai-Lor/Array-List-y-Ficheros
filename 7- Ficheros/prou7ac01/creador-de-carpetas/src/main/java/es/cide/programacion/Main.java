/* 
Fas servir la classe File per crear una estructura de treball. El programa ha de:
Demanar el nom d'una nova carpeta.
Crear-la físicament al disc dur.
Dins d'aquesta carpeta, crear un fitxer buit anomenat hola.txt.
*/

package es.cide.programacion;

public class Main {
    public static void main(String[] args) {
        CreadorCarpetas creadorCarpetas = new CreadorCarpetas();
        creadorCarpetas.iniciar();
    }
}