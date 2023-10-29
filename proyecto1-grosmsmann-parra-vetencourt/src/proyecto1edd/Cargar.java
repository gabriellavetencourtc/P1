/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1edd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author daniela
 */
/**
 * La clase Cargar representa una interfaz gráfica que permite al usuario
 * cargar y actualizar archivos de texto. Esta ventana incluye botones para cargar y 
 * actualizar archivos, así como una área de texto para visualizar el contenido del mismo.
 */
public class Cargar extends javax.swing.JFrame {

    // Atributos de la clase
    JFileChooser seleccionar = new JFileChooser();
    File archivo;

    Principal agregar;
    boolean guardar = false;
    private String aux_usuario;
    private String aux_relacion;
    private String nombreUsuario;

    Mapa m;

   /**
     * Constructor de la clase Cargar.
     *
     * @param m El objeto Mapa asociado a la ventana de Cargar.
     * @param agregar El objeto Principal asociado a la ventana de Cargar.
     */
    public Cargar(Mapa m, Principal agregar) {
        initComponents();
        this.m = m;
        this.agregar = agregar;
        this.setResizable(false);
        this.setTitle("Archivos");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.archivo = null;

    }
/**
     * Abre un archivo de texto y carga su contenido en la interfaz.
     * Si el archivo contiene información válida, se actualiza la visualización y
     * se habilitan las opciones para agregar usuarios.
     */
    public void AbrirTxt() {
        Random random = new Random();
        if (seleccionar.showDialog(this, "Abrir Archivo") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead() && archivo.getName().endsWith("txt")) {
                try ( BufferedReader bf = new BufferedReader(new FileReader(seleccionar.getSelectedFile().toString()))) {
                    String aux;
                    String bfRead;
                    StringBuilder contenidoArchivo = new StringBuilder();

                    boolean leyendoUsuarios = false;
                    boolean contieneUsuarios = false;
                    boolean contieneRelaciones = false;

                    while ((bfRead = bf.readLine()) != null) {
                        aux = bfRead.trim();
                        contenidoArchivo.append(aux).append("\n");

                        if (aux.equalsIgnoreCase("usuarios")) {
                            leyendoUsuarios = true;
                            contieneUsuarios = true;
                        } else if (aux.equalsIgnoreCase("relaciones")) {
                            leyendoUsuarios = false;
                            contieneRelaciones = true;
                        } else if (leyendoUsuarios && aux.startsWith("@")) {
                            nombreUsuario = aux;
                            m.getGrafo().agregarUsuario(nombreUsuario);

                        } else if (!leyendoUsuarios && aux.contains(",")) {
                            String[] arreglo2 = aux.split(",");

                            if (arreglo2.length == 2) {
                                aux_usuario = arreglo2[0].trim();
                                aux_relacion = arreglo2[1].trim();
                                m.getGrafo().agregarRelacion(aux_usuario, aux_relacion, "");
                            }
                        }
                    }
                    if (!contieneUsuarios || !contieneRelaciones) {
                        JOptionPane.showMessageDialog(this, "El archivo no cumple con el formato");
                    } else {
                        texto.setText(contenidoArchivo.toString());
                        agregar.getUsuario().setEnabled(true);
                    }
                } catch (Exception e) {
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un archivo de texto");
            }
        }

    }
/**
     * Actualiza un archivo de texto con la información del grafo.
     * Se permite al usuario seleccionar el archivo de destino.
     */
    public void Actualizar() {
        int input = 1;
        do {
            if (seleccionar.showDialog(this, "Actualizar") == JFileChooser.APPROVE_OPTION) {
                File archivo = new File(seleccionar.getSelectedFile().toString());
                if (archivo.canRead() && archivo.getName().endsWith("txt")) {
                    if (archivo.exists()) {
                        input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas actualizar la información?");

                    }
                    if (input == 0 || !archivo.exists()) {
                        try {
                            input = 0;
                            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                            bw.write("usuarios");
                            bw.newLine();
                            for (int i = 0; i < m.getGrafo().getUsuarios().length; i++) {
                                if (m.getGrafo().getUsuarios()[i] != null) {
                                    bw.write(m.getGrafo().getUsuarios()[i].getNombre());
                                    bw.newLine();
                                }
                            }
                            bw.write("relaciones");
                            bw.newLine();
//                        for (int i = 0; i < m.getGrafo().getRelacion().length; i++) {
//                            if (m.getGrafo().getRelacion()[i] != null) {
//                                bw.write(m.getGrafo().getRelacion()[i].getUsuario1().getNombre() + "," + m.getGrafo().getRelacion()[i].getUsuario2().getNombre());
//                                bw.newLine();
//                            }
//                        }
                            Nodo aux = m.getGrafo().getLusuarios().getpFirst();
                            Nodo aux2 = m.getGrafo().getLrelaciones().getpFirst();
                            while (aux != null && aux2 != null) {
                                bw.write(aux.getDato() + "," + aux2.getDato());
                                bw.newLine();
                                aux = aux.getpNext();
                                aux2 = aux2.getpNext();
                            }

                            bw.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Cargar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Por favor seleccione un archivo de texto");

                }

            }
        } while (input == 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cargar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cargar.setText("Cargar Archivo");
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });
        getContentPane().add(cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 69, -1, -1));

        actualizar.setText("Actualizar Archivo");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 110, -1, -1));

        texto.setEditable(false);
        texto.setColumns(20);
        texto.setRows(5);
        texto.setFocusable(false);
        jScrollPane1.setViewportView(texto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 6, 410, 352));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pasted Graphic 1.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 100, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Screen Shot 2023-10-28 at 4.01.20 PM.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Maneja el evento de hacer clic en el botón "Actualizar Archivo".
     * Este método llama a la función de actualización del archivo.
     *
     * @param evt El evento de acción que desencadena este método.
     */
    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
        this.Actualizar();
        //guarda el txt existente y si hay cambios en el proyecto puede guardar la info nueva y reescribir el txt

    }//GEN-LAST:event_actualizarActionPerformed

    /**
     * Maneja el evento de hacer clic en el botón "Cargar Archivo".
     * Este método abre un cuadro de diálogo para seleccionar un archivo de texto
     * y si cumple con los requisitos, carga su contenido en la aplicación.
     *
     * @param evt El evento de acción que desencadena este método.
     */
    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
        // TODO add your handling code here:
        if (m.getGrafo().esVacio()) {
            this.AbrirTxt();
        } else {
            String[] options = {"Guardar", "No guardar", "Cancelar"};
            int x = JOptionPane.showOptionDialog(null, "¿Desea guardar los cambios realizados al proyecto?",
                    "ALERTA",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            System.out.println(x);

            if (x == 0) {
                this.Actualizar();
                m.reset();
                this.AbrirTxt();

            } else if (x == 1) {
                m.reset();
                this.AbrirTxt();
            }
        }


    }//GEN-LAST:event_cargarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton cargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
