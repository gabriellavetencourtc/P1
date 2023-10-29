/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author daniela
 */
/**
 * La clase Circulo representa un círculo en un plano de dos dimensiones.
 * Cada círculo está definido por sus coordenadas (x, y), un nombre asociado
 * (que es el nombre de un usuario), un diámetro constante (d) y un color.
 */
public class Circulo {
    private int x;
    private int y;
    String nombre;
    public static final int d=35; //diametro del circulo
    public Color color;

    public Circulo(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre; //el nombre es el usuario
        this.color = Color.PINK; 
    }
    
    
    public Circulo(int x, int y){
        this.x = x;
        this.y = y;
        this.nombre="";
        this.color = Color.WHITE; 
    }

   /**
     * Dibuja el círculo con su nombre.
     *
     * @param g El objeto Graphics en el que se dibujará el círculo.
     */
    public void Usuario1(Graphics g){
        g.setColor(color);
        g.fillOval(x-d/2, y-d/2, d, d);
        g.setColor(Color.BLACK);
        g.drawString(nombre, x-d/3, y+d/6); //para que me salga el nombre en el circulo
    }

/**
     * Retorna la coordenada x del centro del círculo.
     *
     * @return La coordenada x del centro del círculo.
     */
    public int getX() {
        return x;
    }
/**
     * Establece la coordenada x del centro del círculo.
     *
     * @param x La nueva coordenada x del centro del círculo.
     */
    public void setX(int x) {
        this.x = x;
    }
/**
     * Retorna la coordenada y del centro del círculo.
     *
     * @return La coordenada y del centro del círculo.
     */
    public int getY() {
        return y;
    }
/**
     * Establece la coordenada y del centro del círculo.
     *
     * @param y La nueva coordenada y del centro del círculo.
     */
    public void setY(int y) {
        this.y = y;
    }
/**
     * Retorna el nombre asociado al círculo.
     *
     * @return El nombre asociado al círculo.
     */
    public String getNombre() {
        return nombre;
    }
/**
     * Establece el nombre asociado al círculo.
     *
     * @param nombre El nuevo nombre asociado al círculo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
     * Retorna el color del círculo.
     *
     * @return El color del círculo.
     */
    public Color getColor() {
        return color;
    }
/**
     * Establece el color del círculo.
     *
     * @param color El nuevo color del círculo.
     */
    public void setColor(Color color) {
        this.color = color;
    }

}

    

