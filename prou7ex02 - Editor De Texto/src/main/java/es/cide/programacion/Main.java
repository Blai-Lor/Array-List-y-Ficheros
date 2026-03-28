package es.cide.programacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    //Inicializamos los botones, el area de texto, el frame, el file y el filechooser
    public static JButton nuevo, abrir, guardar, guardarComo;
    public static JTextArea areaTexto; 
    public static JFrame frame;
    public static File file;
    public static JFileChooser filechooser;

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

        frame = new JFrame("Editor de Texto - [Blai]");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLayout(new BorderLayout(10, 10));

        //Panel de los botones
        JPanel panel1Botones = new JPanel(); //Panel de los botones
        panel1Botones.setLayout(new GridLayout(1, 4, 10, 10)); //1 fila con 4 columnas
        panel1Botones.setBorder(new EmptyBorder(10, 10, 0, 10)); //Margen superior, lateral e inferior
        
        filechooser = new JFileChooser(); //Creamos el filechooser para abrir y guardar archivos
        nuevo = new JButton("📄 Nuevo"); //Creamos el boton de Nuevo
        abrir = new JButton("📂 Abrir"); //Creamos el boton de Abrir
        guardar = new JButton("💾 Guardar"); //Creamos el boton de Guardar
        guardarComo = new JButton("💾➕ Guardar como"); //Creamos el boton de Guardar como
        panel1Botones.add(nuevo);
        panel1Botones.add(abrir);
        panel1Botones.add(guardar);
        panel1Botones.add(guardarComo);

        //El JTextArea ocupara el centro de la ventana
        areaTexto = new JTextArea();
        areaTexto.setLineWrap(true); //Salto de linea automatico
        areaTexto.setWrapStyleWord(true); //No corta las palabras al escribir tanto

        //Panel de escritura
        JPanel panel2Escritura = new JPanel(); 
        panel2Escritura.setLayout(new GridLayout(1, 1));
        panel2Escritura.setBorder(new EmptyBorder(10, 15, 15, 15)); //Margen superior, lateral e inferior
        
        //El Scroll para el texto
        JScrollPane scroll = new JScrollPane(areaTexto);
        panel2Escritura.add(scroll);

        //Boton: Nuevo
        nuevo.addActionListener(e -> {
            areaTexto.setText(""); //Borra todo el texto que hay en el area de escritura
            file = null; //Resetea el fichero actual a null
        });

        //Boton: Abrir
        abrir.addActionListener(e -> Abrir());
        
        //Boton: Guardar
        guardar.addActionListener(e -> Guardar(false));

        //Boton: Guardar como
        guardarComo.addActionListener(e -> Guardar(true));

        //Añadimos los paneles
        frame.add(panel1Botones, BorderLayout.NORTH); //Aparecera arriba
        frame.add(panel2Escritura, BorderLayout.CENTER); //Aparecera en el centro

        frame.setLocationRelativeTo(null); //Centra la ventana en la pantalla al aparecer
        frame.setVisible(true);
    }

    public static void Abrir() {
        int resultado = filechooser.showOpenDialog(frame); //Abre el selector de archivos

        if (resultado == JFileChooser.APPROVE_OPTION) { //Si el usuario selecciona un fichero y le da al boton "Aceptar"
            file = filechooser.getSelectedFile(); //Guarda el archivo seleccionado

            try (FileInputStream fis = new FileInputStream(file)) { //Abre el archivo para leer
                byte[] datos = fis.readAllBytes(); //Lee el contenido
                areaTexto.setText(new String(datos, "UTF-8")); //Pasa el contenido de bytes a UTF-8 y muestra el contenido
            } catch (Exception ex) { //Si hay algun error
                ex.printStackTrace(); //Muestra que error es
            }
        }
    }

    public static void Guardar(boolean guarda) {
        if (file == null || guarda) { //Si no hay ningun fichero actual, es como si fuera un "Guardar como"
            int resultado = filechooser.showSaveDialog(frame); //Enseña que se ha guardado con un mensaje
            if (resultado != JFileChooser.APPROVE_OPTION) { //Verifica que se ha seleccionado una ruta
                return;
            }

            file = filechooser.getSelectedFile(); //Guarda el archivo seleccionado
        }

        //Metodo para escribir el contenido en un fichero
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(areaTexto.getText().getBytes("UTF-8")); //Pasa el texto a bytes con el UTF-8 y lo escribe secuencialmente en el fichero
            JOptionPane.showMessageDialog(frame, "Guardado con éxito"); //Muestra un mensaje de que el fichero se ha guardado correctamente
        } catch (IOException ex) { //Si hay algun error
            ex.printStackTrace(); //Muestra que error es
        }
    }
}