package es.cide.programacion;

import java.util.ArrayList;

public class GestioVols implements IGestioPassatgers {
    ArrayList<String> llistaPassatgers;

    //Constructor
    public GestioVols(){
        this.llistaPassatgers = new ArrayList<>(); //Inicializa el ArrayList
    }

    //Añade un elemento al string
    @Override
    public void registrarPassatger(String nom) {
        llistaPassatgers.add(nom);
    }

    //Modifica el elemento de un string por otro
    @Override
    public void modificarReserva(int index, String nouNom) {
        llistaPassatgers.set(index, nouNom);
    }

    //Elimina el elemento
    @Override
    public void cancelarReserva(String nom) {
        llistaPassatgers.remove(nom);
    }

    //Asocia el nombre del index y lo devuelve
    @Override
    public String obtenirPassatger(int index) {
        String indice = llistaPassatgers.get(index);
        return indice;
    }

    //Lista los pasajeros con for-each
    @Override
    public void llistarPassatgers() {
        for (String element : llistaPassatgers) {
            System.out.println(element);
        }
    }

}
