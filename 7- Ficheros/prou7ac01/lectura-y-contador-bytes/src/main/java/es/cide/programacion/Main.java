/*
Ara anem a llegir el que hem creat a l'exercici anterior. Fes un programa que:
Obri el fitxer dades.txt amb un FileInputStream.
Llegeixi tot el contingut i el mostri per consola.
Al final, digui quants bytes totals ocupa el fitxer (pots fer-ho sumant les lectures o usant el mètode length()).
*/

package es.cide.programacion;

public class Main {
    public static void main(String[] args) {
        LecturaContadorBytes lecturaContadorBytes = new LecturaContadorBytes();
        lecturaContadorBytes.iniciar();
    }
}