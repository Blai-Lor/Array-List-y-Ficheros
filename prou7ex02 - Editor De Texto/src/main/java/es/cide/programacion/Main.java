package es.cide.programacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Main {
    //Inicializamos el archivo actual en un array para poder modificarlo dentro de los eventos
    static File[] archivoActual = {null};

    public static void main(String[] args) {
        //Look And Feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.put("nimbusBlueGrey", new Color(240, 240, 240));
                    UIManager.put("control", new Color(245, 245, 235));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Frame
        JFrame menuFrame = new JFrame("Editor de Texto - [Blai]");
        menuFrame.setSize(600, 450);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.setLocationRelativeTo(null);

        //Panel de los botones
        JPanel panel1Botones = new JPanel(); 
        panel1Botones.setLayout(new GridLayout(1, 4, 10, 10));
        panel1Botones.setBorder(new EmptyBorder(10, 10, 0, 10)); 
        
        JButton botonNuevo = new JButton("📄 Nuevo"); 
        JButton botonAbrir = new JButton("📂 Abrir"); 
        JButton botonGuardar = new JButton("💾 Guardar"); 
        JButton botonGuardarComo = new JButton("💾➕ Guardar como"); 
        panel1Botones.add(botonNuevo);
        panel1Botones.add(botonAbrir);
        panel1Botones.add(botonGuardar);
        panel1Botones.add(botonGuardarComo);

        //El JTextArea ocupara el centro de la ventana
        JTextArea areaTexto = new JTextArea();
        areaTexto.setLineWrap(true); 
        areaTexto.setWrapStyleWord(true); 

        //El Scroll para el texto
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setBorder(new EmptyBorder(5, 5, 5, 5));

        //Creamos el filechooser para abrir y guardar archivos
        JFileChooser fileEsc = new JFileChooser();
        
        //Boton: Nuevo
        botonNuevo.addActionListener(e -> {
            areaTexto.setText(""); 
            archivoActual[0] = null;
        });

        //Boton: Abrir
        botonAbrir.addActionListener(e -> {
            //Abre el selector de archivos para elegir cual queremos abrir
            if (fileEsc.showOpenDialog(menuFrame) == JFileChooser.APPROVE_OPTION) {
                archivoActual[0] = fileEsc.getSelectedFile(); //Guarda el archivo que hemos elegido
                try (FileInputStream lectura = new FileInputStream(archivoActual[0])) { //Para leer los bytes del archivo
                    byte[] todosLosBytes = lectura.readAllBytes(); //Lee todo el contenido del archivo en bytes
                    areaTexto.setText(new String(todosLosBytes)); //Convertimos esos bytes en texto normal que podamos leer
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(menuFrame, "Error al abrir el archivo");
                }
            }
        });

        //Boton: Guardar Como
        botonGuardarComo.addActionListener(e -> {
            //Abre el selector de archivos para elegir cual queremos abrir
            if (fileEsc.showSaveDialog(menuFrame) == JFileChooser.APPROVE_OPTION) {
                archivoActual[0] = fileEsc.getSelectedFile(); //Guarda el archivo que hemos elegido
                
                try (FileWriter escribo = new FileWriter(archivoActual[0])) { //Guarda el contenido del JTextArea
                    areaTexto.write(escribo); //Escribe el contenido
                    JOptionPane.showMessageDialog(menuFrame, "Guardado correctamente");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(menuFrame, "Error al guardar");
                }
            }
        });

        //Boton: Guardar
        botonGuardar.addActionListener(e -> {
            if (archivoActual[0] == null) { //Si el archivo es nuevo, pide una nueva ruta
                if (fileEsc.showSaveDialog(menuFrame) == JFileChooser.APPROVE_OPTION) {
                    archivoActual[0] = fileEsc.getSelectedFile(); //Si lo acepta lo guarda
                }
            }

            //Si ya hay una ruta
            if (archivoActual[0] != null) {
                try (FileWriter escribo = new FileWriter(archivoActual[0])) {
                    areaTexto.write(escribo);
                    JOptionPane.showMessageDialog(menuFrame, "Guardado correctamente");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(menuFrame, "Error al guardar");
                }
            }
        });

        //Añadimos los paneles
        menuFrame.add(panel1Botones, BorderLayout.NORTH);
        menuFrame.add(scroll, BorderLayout.CENTER);
        menuFrame.setVisible(true);
    }
}
