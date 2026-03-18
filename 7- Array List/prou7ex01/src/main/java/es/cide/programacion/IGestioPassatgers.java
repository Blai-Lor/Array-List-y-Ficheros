package es.cide.programacion;

public interface IGestioPassatgers {
    /** Afegeix un passatger a la llista */
    void registrarPassatger(String nom);
    
    /** Substitueix un passatger per un altre en una posició concreta */
    void modificarReserva(int index, String nouNom); 
    
    /** Elimina un passatger pel seu nom complet */
    void cancelarReserva(String nom); 
    
    /** Retorna el nom del passatger d'una posició específica */
    String obtenirPassatger(int index); 
    
    /** Imprimeix tots els passatgers per consola */
    void llistarPassatgers(); 
}

