/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author federicagrossmann
 */
/**
 * La clase Pila representa una estructura de datos de tipo pila (LIFO).
 *
 * @param <T> Tipo de dato que la pila contendrá.
 */
public class Pila<T> {
    //LIFO
    private Nodop<T> pCima;
    private Nodop<T> pBase;
    private int size;

    /**
     * Constructor de la clase Pila. Inicializa una nueva pila vacía.
     */
    public Pila() {
        this.pCima = null;
        this.pBase = null;
        this.size = 0;

    }

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param data El dato a ser agregado a la pila.
     */
    public void push(T data) {
        Nodop<T> nuevoNodo = new Nodop<>(data);
        if (isEmpty()) {
            pCima = nuevoNodo;
            pBase = nuevoNodo;
        } else {
            nuevoNodo.setpNext(pCima);
            pCima = nuevoNodo;
        }
        size++;
    }

    /**
     * Elimina y retorna el elemento en la cima de la pila.
     *
     * @return El dato eliminado de la cima de la pila.
     */
    //elimina elemento
    public T pop() {
        if (isEmpty()) {
            System.out.println("Pila vacía");
        }
        T datoEliminado = pCima.getData();
        if (pCima == pBase) {
            pCima = null;
            pBase = null;
        } else {
            pCima = pCima.getpNext();
        }
        size--;
        return datoEliminado;
    }

    /**
     * Retorna el elemento en la cima de la pila sin eliminarlo.
     *
     * @return El dato en la cima de la pila.
     */
    //retorna cima
    public T top() {
        if (isEmpty()) {
            System.out.println("Pila vacía");
        }
        return pCima.getData();
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return `true` si la pila está vacía, de lo contrario `false`.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Imprime los elementos de la pila.
     */
    public void imprimir() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
        } else {
            Nodop<T> actual = pCima;
            while (actual != null) {
                System.out.print(actual.getData() + " ");
                actual = actual.getpNext();
            }
            System.out.println();
        }
    }

    /**
     * @return the pCima
     */
    public Nodop<T> getpCima() {
        return pCima;
    }

    /**
     * @param pCima the pCima to set
     */
    public void setpCima(Nodop<T> pCima) {
        this.pCima = pCima;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the pBase
     */
    public Nodop<T> getpBase() {
        return pBase;
    }

    /**
     * @param pBase the pBase to set
     */
    public void setpBase(Nodop<T> pBase) {
        this.pBase = pBase;
    }

}
