/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author daniela
 */
/**
 * La clase Proyecto1EDD es la clase principal que contiene el método main para iniciar la aplicación.
 */
public class Proyecto1EDD {

   /**
     * Método principal para iniciar la aplicación.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Definir ventana
        Mapa m=new Mapa();
   
       Principal a=new Principal(m);
      
      
       a.getContentPane().add(m);
 
       
        a.setVisible(true);

    }
    
}
