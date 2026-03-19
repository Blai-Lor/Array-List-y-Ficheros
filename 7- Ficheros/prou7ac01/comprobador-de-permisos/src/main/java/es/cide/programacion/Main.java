/*
Fes un programa que rebi el nom d'un fitxer i ens digui la seva "fitxa tècnica":
Indicar si és un fitxer o un directori.
Indicar si tenim permisos de lectura i d'escriptura.
Mostrar la seva ruta absoluta completa.
*/

package es.cide.programacion;

public class Main {
    public static void main(String[] args) {
        ComprobadorDePermisos comprobadorPermisos = new ComprobadorDePermisos();
        comprobadorPermisos.iniciar();
    }
}