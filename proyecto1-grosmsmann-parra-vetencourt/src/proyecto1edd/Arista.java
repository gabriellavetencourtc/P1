/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author daniela
 */
class Arista {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private String u1;
    private String u2;
    public Color color;
    private boolean eliminar;
    public static final int arrowSize = 10;

    public Arista(int x1, int y1, int x2, int y2, String u1, String u2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.u1 = u1;
        this.u2 = u2;
        this.color=Color.PINK;
        this.eliminar=false;
    }
    
    /**
 * Dibuja una línea con una cabeza de flecha en el extremo.
 *
 * @param g El objeto Graphics en el que se dibujará la línea.
 */
       public void pintarL1(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color.ORANGE);

        // Dibujar la línea
        g2.drawLine(x1, y1, x2, y2);

        double angle = Math.atan2(y2 - y1, x2 - x1);

        // Dibujar la punta de la flecha
        int arrowSize = 10; 
        int xArrow = (int) (x2 - arrowSize * Math.cos(angle - Math.PI / 6));
        int yArrow = (int) (y2 - arrowSize * Math.sin(angle - Math.PI / 6));

        int[] xPoints = {x2, xArrow, (int) (x2 - arrowSize * Math.cos(angle + Math.PI / 6))};
        int[] yPoints = {y2, yArrow, (int) (y2 - arrowSize * Math.sin(angle + Math.PI / 6))};

        g2.fillPolygon(new Polygon(xPoints, yPoints, 3)); 

    }
/**
     * Retorna el valor menor entre dos números.
     *
     * @param n1 Primer número a comparar.
     * @param n2 Segundo número a comparar.
     * @return El valor menor entre n1 y n2.
     */
    private int menor(int n1, int n2) {
        if (n1 < n2) {
            return n1;

        } else {
            return n2;
        }
    }
/**
     * Retorna el valor mayor entre dos números.
     *
     * @param n1 Primer número a comparar.
     * @param n2 Segundo número a comparar.
     * @return El valor mayor entre n1 y n2.
     */
    private int mayor(int n1, int n2) {
        if (n1 > n2) {
            return n1;
        } else {
            return n2;
        }
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1;
    }

    public String getU2() {
        return u2;
    }

    public void setU2(String u2) {
        this.u2 = u2;
    }

}
