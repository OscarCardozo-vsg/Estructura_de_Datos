package org.usta.misclases;

public class listaSimpleCircular {

    public Nodo cabeza;
    public Nodo cola;
    public int tamano;

    public listaSimpleCircular() {
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
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cabeza.setSiguiente(cabeza);
        } else {
            cola.setSiguiente(nuevoNodo);
            cola = nuevoNodo;
            cola.setSiguiente(cabeza);
        }
        tamano++;
    }

    public void eliminar(int posicion) {
        if (0 <= posicion && posicion < tamano) {
            if (posicion == 0) {
                if (cabeza == cola) {
                    cabeza = null;
                    cola = null;
                } else {
                    cabeza = cabeza.getSiguiente();
                    cola.setSiguiente(cabeza);
                }
            } else {
                Nodo tempoNodo = cabeza;

                for (int i = 0; i < posicion - 1; i++) {
                    tempoNodo = tempoNodo.getSiguiente();
                }
                Nodo siguiente = tempoNodo.getSiguiente();
                System.out.println("Eliminando posicion: " + posicion);
                tempoNodo.setSiguiente(siguiente.getSiguiente());
            }
            tamano--;
        } else {
            System.out.println("Posicion no valida.");
        }
    }

    public void imprimir() {
        Nodo tempoNodo = cabeza;
        int indice = 0;

        if (cabeza != null) {
            System.out.println("****************************************");
            do {
                System.out.println("En la lista simple circular,["+indice +"] el nodo:[" + ajustarNombre(tempoNodo) + "], tiene el dato[" + tempoNodo.getDato() + "] y esta ampuntando al nodo[" + ajustarNombre(tempoNodo.getSiguiente()) + "].");
                tempoNodo = tempoNodo.getSiguiente();
                indice++;
                
            } while (tempoNodo != cabeza);
            System.out.println("****************************************");
        } else {
            System.out.println("La lista esta vacia.");
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
