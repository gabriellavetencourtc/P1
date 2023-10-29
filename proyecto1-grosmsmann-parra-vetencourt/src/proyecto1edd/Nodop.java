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
 * La clase Nodo representa un elemento individual en una estructura de datos de tipo pila.
 *
 * @param <T> Tipo de dato que el nodo contiene.
 */
public class Nodop<T> {
    private Nodop<T> pNext;
    private T data;

    public Nodop(T data) {
        this.pNext = null;
        this.data = data;
    }

    /**
     * @return the pNext
     */
    public Nodop<T> getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodop<T> pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }    
}
