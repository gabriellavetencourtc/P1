/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author daniela
 */
/**
 * La clase Grafo representa la estructura de grafo que contiene usuarios y relaciones.
 * Permite agregar y eliminar usuarios, así como agregar relaciones entre ellos.
 * También gestiona la representación visual del grafo en un mapa.
 */
public class Grafo {

    private Usuario[] usuarios;
    private int[][] matrizA;
    private Mapa mapa;
    private int usuarioSize;
    Relacion[] relacion;
    private Lista lusuarios;
    private Lista lrelaciones;

    public Grafo(Mapa m) {
        this.usuarios = new Usuario[50];
        this.matrizA = new int[usuarios.length][usuarios.length];
        this.relacion = new Relacion[50];
        this.mapa = m;
        lusuarios = new Lista();
        lrelaciones = new Lista();

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                matrizA[i][j] = 0;
            }
        }
    }
/**
     * Obtiene la matriz de adyacencia del grafo.
     *
     * @return La matriz de adyacencia.
     */
    public int[][] getMatrizA() {
        return matrizA;
    }
/**
     * Obtiene el arreglo de usuarios del grafo.
     *
     * @return El arreglo de usuarios.
     */
    public Usuario[] getUsuarios() {
        return usuarios;
    }
/**
     * Obtiene la lista de usuarios del grafo.
     *
     * @return La lista de usuarios.
     */
    public Lista getLusuarios() {
        return lusuarios;
    }
/**
     * Obtiene la lista de relaciones del grafo.
     *
     * @return La lista de relaciones.
     */
    public Lista getLrelaciones() {
        return lrelaciones;
    }
/**
     * Obtiene el tamaño actual de la lista de usuarios.
     *
     * @return El tamaño de la lista de usuarios.
     */
    public int getusuarioSize() {
        return usuarioSize;
    }
/**
     * Obtiene el arreglo de relaciones del grafo.
     *
     * @return El arreglo de relaciones.
     */
    public Relacion[] getRelacion() {
        return relacion;
    }
/**
     * Establece el arreglo de relaciones del grafo.
     *
     * @param relacion El arreglo de relaciones a establecer.
     */
    public void setRelacion(Relacion[] relacion) {
        this.relacion = relacion;
    }
/**
     * Verifica si el grafo está vacío (sin usuarios).
     *
     * @return true si el grafo está vacío, false en caso contrario.
     */
    public boolean esVacio() {
        boolean vacio = true;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                vacio = false;
            }
        }

        return vacio;
    }
/**
     * Agrega un usuario al grafo con el nombre proporcionado.
     *
     * @param nombre El nombre del usuario a agregar.
     */
    public void agregarUsuario(String nombre) {
        if (usuarioSize < usuarios.length) {
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i] == null) {
                    usuarios[i] = new Usuario(nombre);
                    usuarioSize++;
                    Random random = new Random();
                    mapa.getCirculo().add(new Circulo(random.nextInt(700), random.nextInt(500), nombre.trim()));
                    mapa.repaint();
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Número máximo de usuarios alcanzado.");
        }
    }
/**
     * Elimina un usuario del grafo en la posición indicada por el índice.
     *
     * @param indice El índice del usuario a eliminar.
     * @throws IndexOutOfBoundsException Si el índice está fuera de rango.
     */
    public void eliminar(int indice) {
        if (indice < 0 || indice >= usuarioSize) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        for (int i = indice; i < usuarioSize - 1; i++) {
            usuarios[i] = usuarios[i + 1];
        }
        usuarios[usuarioSize - 1] = null;
        usuarioSize--;
    }
/**
     * Elimina un usuario del grafo por su nombre.
     *
     * @param nombre El nombre del usuario a eliminar.
     */
    public void EliminarUsuario(String nombre) {
        int posUsuario = -1;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getNombre().equalsIgnoreCase(nombre)) {
                eliminar(i);
                posUsuario = i;
                break;
            }
        }

        for (int i = 0; i < mapa.getCirculo().size(); i++) {
            Circulo circulo = mapa.getCirculo().get(i);

            if (circulo.getNombre().equals(nombre)) {
                mapa.getCirculo().remove(i);
                break;
            }
        }

        if (posUsuario != -1) {
            // Elimina relaciones del usuario
            for (int i = 0; i < usuarios.length; i++) {
                matrizA[posUsuario][i] = 0;
                matrizA[i][posUsuario] = 0;
                relacion[posUsuario] = null;
                relacion[i] = null;
            }

            // Elimina aristas (visuales)
            Vector<Arista> nuevasAristas = new Vector<Arista>();
            for (Arista arista : mapa.getArista()) {
                if (!arista.getU1().equals(nombre) && !arista.getU2().equals(nombre)) {
                    nuevasAristas.add(arista);
                }
            }
            mapa.setArista(nuevasAristas);
            mapa.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        }

        Nodo aux = lusuarios.getpFirst();
        Nodo aux2 = lrelaciones.getpFirst();
        while (aux != null && aux2 != null) {
            if (aux.getDato().equals(nombre) || aux2.getDato().equals(nombre)) {
                lusuarios.eliminarElemento(aux.getDato());
                lrelaciones.eliminarElemento(aux2.getDato());
            }
            aux = aux.getpNext();
            aux2 = aux2.getpNext();
        }
    }
/**
     * Agrega una relación entre dos usuarios.
     *
     * @param u1 El nombre del primer usuario.
     * @param u2 El nombre del segundo usuario.
     * @param relacion1 El tipo de relación entre los usuarios.
     */
    public void agregarRelacion(String u1, String u2, String relacion1) {
        int posU1 = -1;
        int posU2 = -1;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].getNombre().equalsIgnoreCase(u1)) {
                    posU1 = i;
                    lusuarios.InsertarFinal(usuarios[i].getNombre());
                }
                if (usuarios[i].getNombre().equalsIgnoreCase(u2)) {
                    posU2 = i;
                    lrelaciones.InsertarFinal(usuarios[i].getNombre());
                }
            }
        }
        if (posU1 != -1 && posU2 != -1 && matrizA[posU1][posU2] == 0) {
            matrizA[posU1][posU2] = 1;
            relacion[posU1] = new Relacion(usuarios[posU1], usuarios[posU2]);

            // Agregar la arista al grafo (lo que se ve)
            mapa.getArista().add(new Arista(
                    mapa.getCirculo().elementAt(posU1).getX(),
                    mapa.getCirculo().elementAt(posU1).getY(),
                    mapa.getCirculo().elementAt(posU2).getX(),
                    mapa.getCirculo().elementAt(posU2).getY(),
                    u1, u2
            ));
            mapa.repaint();
        }
    }
/**
     * Busca un usuario por su nombre.
     *
     * @param nombre El nombre del usuario a buscar.
     * @return El usuario si se encuentra, o null si no se encuentra.
     */
    public Usuario buscarUsuario(String nombre) {
        Usuario aux = null;
        boolean found = false;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].getNombre().equalsIgnoreCase(nombre)) {

                    aux = usuarios[i];
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            return aux;
        } else {
            return null;
        }
    }
}
