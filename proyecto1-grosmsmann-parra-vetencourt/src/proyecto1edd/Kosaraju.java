/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import java.awt.Color;


/**
 *
 * @author gabriellavetencourt
 */
/**
 * La clase Kosaraju implementa el algoritmo de Kosaraju para encontrar componentes
 * fuertemente conectados en un grafo dirigido. También proporciona métodos para cambiar
 * el color de los nodos en el mapa según las componentes encontradas.
 */
public class Kosaraju {

    private Grafo grafo;
    private Lista<Lista> sccList;
    private Pila stack;
    private Mapa m;

/**
     * Constructor de la clase Kosaraju.
     *
     * @param grafo El grafo sobre el cual se aplicará el algoritmo.
     * @param m     El objeto Mapa asociado al grafo.
     */
    public Kosaraju(Grafo grafo, Mapa m) {
        this.grafo = grafo;
        this.sccList = new Lista();
        this.stack = new Pila();
        this.m = m;
    }
    
    /**
     * Realiza un recorrido en profundidad (DFS) para llenar una pila de vértices.
     *
     * @param v        El vértice actual.
     * @param visited  Arreglo que indica si un vértice ha sido visitado.
     * @param stack    La pila de vértices.
     */
     private void DFS(int v, boolean[] visited, Pila stack) {
        visited[v] = true;
        for (int i = 0; i < v; i++) {
            if (grafo.getMatrizA()[v][i] == 1 && !visited[i]) {
                DFS(i, visited, stack);
            }
        }
        stack.push(v);
    }
     
/**
     * Realiza un segundo recorrido en profundidad (DFS) para encontrar componentes fuertemente conexas.
     *
     * @param v        El vértice actual.
     * @param visited  Arreglo que indica si un vértice ha sido visitado.
     * @param component Lista que representa un componente fuertemente conectado.
     */
    private void DFS2(int v, boolean[] visited, Lista component) {
        visited[v] = true;
        component.InsertarFinal(grafo.getUsuarios()[v].getNombre());

        for (int i = 0; i < grafo.getusuarioSize(); i++) {
            if (grafo.getMatrizA()[v][i] == 1 && !visited[i]) {
                DFS2(i, visited, component);
            }
        }
    }

/**
     * Obtiene la lista de componentes fuertemente conexas encontradas en el grafo.
     *
     * @return La lista de componentes fuertemente conexas.
     */
    public Lista<Lista> getScc() {
 
        boolean[] visited = new boolean[grafo.getusuarioSize()];
        
        for (int i = 0; i < grafo.getusuarioSize(); i++) {
            if (!visited[i]) {
                DFS(i, visited, stack);
            }
        }

        visited = new boolean[grafo.getusuarioSize()];

        while (!stack.isEmpty()) {
            int v = (int) stack.pop();
            if (!visited[v]) {
                Lista<Integer> component = new Lista<>();
                DFS2(v, visited, component);
                sccList.InsertarFinal(component);
            }
        }
        return sccList;
    }
    
    /**
     * Cambia el color de los nodos en el mapa según los componentes fuertemente conectados.
     */
    public void CambiarColor() {
    Color[] colores = {Color.red, Color.green, Color.blue, Color.cyan, Color.pink,Color.orange, Color.magenta }; // Puedes agregar más colores si es necesario
    Nodo aux = sccList.getpFirst();
    int colorIndex = 0; // Índice para obtener el color de la lista actual
    while (aux != null) {
        Lista lista = (Lista) aux.getDato();
        Nodo aux2 = lista.getpFirst();
        Color color = colores[colorIndex]; // Obtiene el color actual
        while (aux2 != null) {
            for (int i = 0; i < grafo.getusuarioSize(); i++) {
                if (aux2.getDato().toString().equals(grafo.getUsuarios()[i].getNombre().trim())) {
                    m.getCirculo().get(i).setColor(color); // Asigna el color al nodo en el mapa (m)
                }
            }
            aux2 = aux2.getpNext();
        }
        aux = aux.getpNext();
        colorIndex = (colorIndex + 1) % colores.length; // Avanza al siguiente color en el array de colores
    }
    m.repaint();
}

}


