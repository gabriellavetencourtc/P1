/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author daniela
 * @param <T>
 */
/**
 * La clase Lista T implementa una lista enlazada.
 *
 * @param <T> Tipo de datos de los elementos de la lista.
 */
public class Lista<T> {

    private Nodo<T> pFirst;
    private int size;
    private Nodo<T> pLast;

    public Lista() {
        this.pFirst = null;
        this.size = 0;
        this.pLast = null;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false de lo contrario.
     */
    public boolean esVacio() {
        return pFirst == null;
    }

    /**
     * Inserta un elemento al final de la lista.
     *
     * @param dato El elemento a insertar.
     */
    public void InsertarFinal(T dato) {
        Nodo newnodo = new Nodo(dato);
        Nodo aux = pFirst;
        if (esVacio()) {
            pFirst = newnodo;
        } else {
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(newnodo);
        }
        size++;
    }

    /**
     * Imprime los elementos de la lista en una cadena de texto.
     *
     * @return Una cadena de texto con los elementos de la lista.
     */
    public String Imprimir() {
        String aux1 = "";
        Nodo aux = pFirst;
        if (esVacio()) {
            System.out.println("La lista es vacía");
        } else {
            while (aux != null) {
                aux1+=aux.getDato() + "\n";
                aux = aux.getpNext();
            }
        }
        return aux1;
    }
    
    /**
     * Imprime los elementos de la lista en una cadena de texto, considerando listas internas.
     *
     * @return Una cadena de texto con los elementos de la lista.
     */
    public String Imprimir1() {
        String aux1 = "";
        Nodo aux = pFirst;
        int cont = 1;
        if (esVacio()) {
            System.out.println("La lista es vacía");
        } else {
            while (aux != null) {
                Lista lista = (Lista) aux.getDato();
                aux1+="Usuarios fuertemente conectados " + cont + "\n" + lista.Imprimir() + "\n";
                aux = aux.getpNext();
                cont++;
            }
        }
        return aux1;
    }
    
  /**
     * Elimina el último elemento de la lista.
     */
    public void EliminarFinal() {
        Nodo aux = pFirst;
        if (!esVacio()) {
            while (aux.getpNext().getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(null);
            size--;
        }
    }
    
/**
     * Elimina un elemento específico de la lista.
     *
     * @param dato El elemento a eliminar.
     */
    public void eliminarElemento(T dato) {
        while (pFirst != null && pFirst.getDato() == dato) {
            pFirst = pFirst.getpNext();
        }

        if (esVacio()) {

            return;
        }

        Nodo actual = pFirst;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.getDato() == dato) {
                anterior.setpNext(actual.getpNext());
            } else {
                anterior = actual;
            }
            actual = actual.getpNext();
        }
    }

    /**
     * Obtiene el primer nodo de la lista.
     *
     * @return El primer nodo de la lista.
     */
    public Nodo<T> getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista.
     *
     * @param pFirst El nuevo primer nodo de la lista.
     */
    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Obtiene el tamaño de la lista.
     *
     * @return El tamaño de la lista.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista.
     *
     * @param size El nuevo tamaño de la lista.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Obtiene el último nodo de la lista.
     *
     * @return El último nodo de la lista.
     */
    public Nodo<T> getpLast() {
        return pLast;
    }

    /**
     * Establece el último nodo de la lista.
     *
     * @param pLast El nuevo último nodo de la lista.
     */
    public void setpLast(Nodo<T> pLast) {
        this.pLast = pLast;
    }

}
