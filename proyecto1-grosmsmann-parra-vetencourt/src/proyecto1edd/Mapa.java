/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author daniela
 */
/**
 * La clase Mapa extiende JPanel y sirve como una representación gráfica
 * del grafo y sus elementos (nodos y relaciones) en la aplicación.
 */
 public class Mapa extends JPanel {
    private ArrayList aux_codigoA = new ArrayList();
    private ArrayList<Integer> aux_posX = new ArrayList();
    private ArrayList<Integer> aux_posY = new ArrayList();
    private ArrayList aux_codigoO = new ArrayList();
    private ArrayList aux_codigoD = new ArrayList();

    Usuario auxOrigen;
    Usuario auxDestino;

    private Vector<Circulo> Circulo; //utilizo la clase vector para hacer un array de objetos (import)
    private Vector<Arista> Arista;
    private Point p1;
    private Point p2;
    private Relacion relacion;
    private String codigoA;
    private Grafo grafo;
    int pos = 0;
    int num = 0;
    public boolean crearNodo = false;

    /**
     * Constructor de la clase Mapa.
     * Inicializa las listas de círculos y aristas, y establece
     * algunas configuraciones de la interfaz gráfica.
     */
    public Mapa() {

        this.Circulo = new Vector<>();
        this.Arista = new Vector<>();
        this.grafo = new Grafo(this);
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.PINK));
        this.setSize(800, 550);
        this.p1 = null;
        this.p2 = null;
        this.setBackground(Color.WHITE);
        this.setLocation(125, 50);
    }
    
    /**
     * Reinicia el mapa eliminando todos los elementos gráficos y
     * creando nuevas listas de círculos y aristas.
     */
    public void reset(){
        this.Circulo = new Vector<>();
        this.Arista = new Vector<>();
        this.grafo = new Grafo(this);
        this.p1 = null;
        this.p2 = null;
    }
   
    /**
     * Método que se encarga de dibujar los círculos y aristas en el panel.
     * Se utiliza la librería Graphics.
     *
     * @param g Objeto Graphics para dibujar los elementos.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circulo objCirculo : Circulo) {
            objCirculo.Usuario1(g);
        }
        for (Arista linea : Arista) {
            linea.pintarL1(g);
        }  
    }
    
    
    public ArrayList getAux_codigoA() {
        return aux_codigoA;
    }

    public void setAux_codigoA(ArrayList aux_codigoA) {
        this.aux_codigoA = aux_codigoA;
    }

    public ArrayList<Integer> getAux_posX() {
        return aux_posX;
    }

    public void setAux_posX(ArrayList<Integer> aux_posX) {
        this.aux_posX = aux_posX;
    }

    public ArrayList<Integer> getAux_posY() {
        return aux_posY;
    }

    public void setAux_posY(ArrayList<Integer> aux_posY) {
        this.aux_posY = aux_posY;
    }

    public ArrayList getAux_codigoO() {
        return aux_codigoO;
    }

    public void setAux_codigoO(ArrayList aux_codigoO) {
        this.aux_codigoO = aux_codigoO;
    }

    public ArrayList getAux_codigoD() {
        return aux_codigoD;
    }

    public void setAux_codigoD(ArrayList aux_codigoD) {
        this.aux_codigoD = aux_codigoD;
    }

    public Usuario getAuxOrigen() {
        return auxOrigen;
    }

    public void setAuxOrigen(Usuario auxOrigen) {
        this.auxOrigen = auxOrigen;
    }

    public Usuario getAuxDestino() {
        return auxDestino;
    }

    public void setAuxDestino(Usuario auxDestino) {
        this.auxDestino = auxDestino;
    }

    public Vector<Circulo> getCirculo() {
        return Circulo;
    }

    public void setCirculo(Vector<Circulo> Circulo) {
        this.Circulo = Circulo;
    }

    public Vector<Arista> getArista() {
        return Arista;
    }

    public void setArista(Vector<Arista> Arista) {
        this.Arista = Arista;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Relacion getRelacion() {
        return relacion;
    }

    public void setRelacion(Relacion relacion) {
        this.relacion = relacion;
    }

    public String getCodigoA() {
        return codigoA;
    }

    public void setCodigoA(String codigoA) {
        this.codigoA = codigoA;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isCrearNodo() {
        return crearNodo;
    }

    public void setCrearNodo(boolean crearNodo) {
        this.crearNodo = crearNodo;
    }

 }