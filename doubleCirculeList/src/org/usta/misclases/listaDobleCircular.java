package org.usta.misclases;

public class listaDobleCircular {

    public Nodo cabeza;
    public Nodo cola;
    public int tamano;

    public listaDobleCircular() {
        inicializar();
    }

    public void inicializar() {
        cabeza = null;
        cola = null;
        tamano = 0;
    }

    public int getTamano() {
        return tamano;
    }

    public void agregar(Object dato) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);

        if (cabeza == null) {
            nuevoNodo.setAnterior(nuevoNodo);
            nuevoNodo.setSiguiente(nuevoNodo);
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.setAnterior(cola);
            cola.setSiguiente(nuevoNodo);
            cabeza.setAnterior(nuevoNodo);
            nuevoNodo.setSiguiente(cabeza);
            cola = nuevoNodo;
        }
        tamano++;
    }

    public void imprimir() {
        Nodo tempoNodo = cabeza;
        int indice = 0;

        while (indice < tamano) {
            System.out.println("[" + indice + "] el nodo:[" + ajustarNombre(tempoNodo) + "], tiene el dato[" + tempoNodo.getDato() + "] y esta ampuntando al nodo siguiente[" + ajustarNombre(tempoNodo.getSiguiente()) + "] y al nodo anteriro[" + ajustarNombre(tempoNodo.getAnterior()) + "].");
            tempoNodo = tempoNodo.getSiguiente();
            indice++;
        }

    }

    public String ajustarNombre(Nodo objeto) {
        if (objeto == null) {
            return null;
        } else {
            String miTexto = objeto.toString();
            String salida = miTexto.substring(miTexto.indexOf("@") + 1);
            return salida;
        }
    }
}
