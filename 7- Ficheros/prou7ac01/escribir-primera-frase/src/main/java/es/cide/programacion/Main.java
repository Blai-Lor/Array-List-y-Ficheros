/*
Utilitzant la classe FileOutputStream, crea un programa que:
Crei un fitxer anomenat dades.txt.
Escrigui la frase "Hola, estic aprenent Java!" caràcter a caràcter (convertint-los a bytes).
Important: No oblidis tancar el flux en el bloc finally.
*/

package es.cide.programacion;

public class Main {
    public static void main(String[] args) {
        EscribirPrimeraFrase primeraFrase = new EscribirPrimeraFrase();
        primeraFrase.iniciar();
    }
}