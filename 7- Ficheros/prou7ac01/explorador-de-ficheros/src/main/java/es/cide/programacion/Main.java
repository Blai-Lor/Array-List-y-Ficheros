/*
Crea un programa que demani a l'usuari una ruta absoluta d'un directori. El programa ha de:
Comprovar si la ruta realment existeix.
Si existeix, mostrar per pantalla el nom de tots els fitxers i subdirectoris que conté.
*/

package es.cide.programacion;

public class Main {
    public static void main(String[] args) {
        ExploradorFicheros exploradorFicheros = new ExploradorFicheros();
        exploradorFicheros.iniciar();
    }
}