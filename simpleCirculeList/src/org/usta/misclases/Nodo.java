package org.usta.misclases;
 
public class Nodo {
    public Object dato;
    public Nodo siguiente;

    public Nodo() {
        dato = null;
        siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
