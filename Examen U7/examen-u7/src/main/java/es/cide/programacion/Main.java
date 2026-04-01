//Nombre: Blai Lorente Fuster
//Fecha: 31/03/2026

package es.cide.programacion;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
    public static Scanner sc;
    public static File archivoEntrada;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cercador de Palíndroms - [Blai]");
        frame.setSize(750, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);

        JTextField caminoFicheroOrigen = new JTextField();
        JButton leer = new JButton("Llegir");
        JPanel panelOrigen = organizar("Fichero Origen:", caminoFicheroOrigen, leer);

        JTextField caminoFicheroDestino = new JTextField();
        JButton desar = new JButton("Desar"); //Creamos el boton de Desar
        desar.setEnabled(false); //Inactivo hasta que se haga el analisis 

        JPanel panelDestino = organizar("Fichero Destino:", caminoFicheroDestino, desar);

        //Panel central para las areas de visualizacion 
        JPanel visualitzacion = new JPanel(new GridLayout(1, 2, 10, 10));

        //Area de linea Polindroma
        JTextArea lineaPolindroma = new JTextArea();
        lineaPolindroma.setEditable(false); //No podemos escribir
        JScrollPane scrollPoli = new JScrollPane(lineaPolindroma);
        JPanel panelSonPoli = new JPanel(new BorderLayout());
        panelSonPoli.add(new JLabel("Palíndrom."), BorderLayout.NORTH);
        panelSonPoli.add(scrollPoli, BorderLayout.CENTER);

        //Area de lineas no Polindromas
        JTextArea lineaNoPolindroma = new JTextArea();
        lineaNoPolindroma.setEditable(false); //No podemos escribir
        JScrollPane scrollNoPoli = new JScrollPane(lineaNoPolindroma);
        JPanel panelNoPoli = new JPanel(new BorderLayout());
        panelNoPoli.add(new JLabel("No Palíndrom."), BorderLayout.NORTH);
        panelNoPoli.add(scrollNoPoli, BorderLayout.CENTER);

        visualitzacion.add(panelSonPoli);
        visualitzacion.add(panelNoPoli);

        //Logica de analizar
        leer.addActionListener(e -> {
            String ruta = caminoFicheroOrigen.getText();
            archivoEntrada = new File(ruta);

            if (!archivoEntrada.exists()) { //Si el archivo no existe muestra este mensaje
                JOptionPane.showMessageDialog(frame, "El fichero no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Limpiamos areas antes de empezar
            lineaPolindroma.setText("");
            lineaNoPolindroma.setText("");

            //Try-catch abre el archivo y lo cierra automaticamente al terminar
            try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
                String linea;
                //Leemos el archivo linea por linea hasta que llegue al final
                while ((linea = br.readLine()) != null) {
                    if (esPolindroma(linea)) {
                        lineaPolindroma.append(linea + "\n");
                    } else {
                        lineaNoPolindroma.append(linea + "\n");
                    }
                }
                desar.setEnabled(true); //Activa el boton de guardar tras analisis 
            } catch (IOException ex) { //Mensaje de error
                JOptionPane.showMessageDialog(frame, "Error al leer el fichero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        desar.addActionListener(e -> {
            String rutaDestino = caminoFicheroDestino.getText();
            if (rutaDestino.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Escribe un camino de destino", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Permite escribir texto en un archivo de forma sencilla.
            try (PrintWriter pw = new PrintWriter(new File(rutaDestino))) {
                pw.print(lineaPolindroma.getText()); //Solo guarda las que son polindromas
                JOptionPane.showMessageDialog(frame, "Ficehro guardado correctamente"); //Mensaje de guardado correctamente
            } catch (IOException ex) { //Mensaje de error
                JOptionPane.showMessageDialog(frame, "Error al guardar el fichero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(panelOrigen, BorderLayout.NORTH);
        frame.add(visualitzacion, BorderLayout.CENTER);
        frame.add(panelDestino, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    //Metodo que organiza visualmente los componentes
    private static JPanel organizar(String etiqueta, JTextField campo, javax.swing.JComponent boton) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //Insets añade un pequeño margen alrededor de los componentes
        gbc.insets = new Insets(5, 5, 5, 5);

        //Etiqueta en el lado izquierdo
        gbc.gridx = 0; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel(etiqueta), gbc);

        //Campo de texto, esta en el centro, se expande horizontalmente
        gbc.gridx = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(campo, gbc);

        //Boton esta en el lado derecho
        gbc.gridx = 2; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        panel.add(boton, gbc);

        return panel;
    }
    
    private static boolean esPolindroma(String poli) {
        String texto = poli.replaceAll("[^a-zA-Z]", "").toLowerCase(); //Elimina los espacios, los caracteres especiales y los pasa a minusculas para que lo lea bien, si no aparece que esta mal
        StringBuilder girado = new StringBuilder(texto).reverse(); //Crea un StringBuilder con el texto sin nada y lo invierte

        return texto.equals(girado.toString()); //Compara el texto limpio con su reverso, si son iguales es polindroma si no, no lo es
    }
}