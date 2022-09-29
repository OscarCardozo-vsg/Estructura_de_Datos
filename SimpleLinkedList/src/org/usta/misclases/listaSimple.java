package org.usta.misclases;

public class listaSimple {

    public Nodo cabeza;
    public int tamano;

    public listaSimple() {
        inicializar();
    }

    private void inicializar() {
        cabeza = null;
        tamano = 0;
    }

    public int getTamaño() {
        return tamano;
    }

    //este metodo hace: cada vez que llamemos al metodo vamos a agregar un nuevo nodo
    public void agregar(Object datoAgregar) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(datoAgregar);

        if (cabeza == null) {//este if hace: si no hay nigun nodo en mi lista entonce que coloque ese nodo como cabeza, es decir que agregue el nodo a la lista y que lo asigne como cabeza(puntero)
            cabeza = nuevoNodo;
        } else {
            Nodo temporal = cabeza;//asignamos a nuestro nodo temporal como la cabeza(puntero) de nuestra lsita 

            while (temporal.getSiguiente() != null) {//este while hace: mientras que el nodo apunte a otro nodo, que pase ese nodo al nodo que esta apuntando hasta que llegue al ultimo(es decir, hasta que temporal.getSiguiente sea null)          
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nuevoNodo);
        }
        tamano++;
    }

    public void imprimir() {
        int indice = 0;
        Nodo temporal = cabeza;

        System.out.println("------------------------------------------------------------------------------------------------------");
        while (temporal != null) {//este while hace: mientras que nuestra lista contenga al menos un nodo, entonces que muestre el nodo y pase al siguiente nodo hasta que no haya nigun nodo siguiente
            System.out.println("en la lista simple, el nodo N°[" + indice + "], identificado con [" + ajustarNombre(temporal) + "] tiene el dato de: (" + temporal.getDato() + "), y esta apuntando al nodo ---->" + ajustarNombre(temporal.getSiguiente()));
            temporal = temporal.getSiguiente();
            indice++;
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
    }

    //este metodo hace: sirve para transformar esto en imprimir: org.usta.misclases.Nodo@1d81eb93 -----> 1d81eb93
    private String ajustarNombre(Nodo objeto) {
        if (objeto == null) {
            return "Null";
        } else {
            String miTexto = objeto.toString();
            String salida = miTexto.substring(miTexto.indexOf("@") + 1);//sirve para acortar la palabra, segun lo que colocamos tomamos desde el @ en adelante
            return salida.trim();
        }
    }

    public void agregarPosicion(int posicion, Object datoAgregar) {
        if (posicion >= 0 && posicion < tamano) {//Este if hace: Evalua que la posicion que nos dieron sea mayor o igual que 0 y menor al tamaño de nuestra lista
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.setDato(datoAgregar);//asignamos el valor dado al nuevo nodo que nos dieron

            if (posicion == 0) {//Este if hace: si la posicion que nos dieron es 0, entonce hacemos que nuestro nuevo nodo apunte a nuestra cabeza 
                 nuevoNodo.setSiguiente(cabeza);
                 cabeza = nuevoNodo;
                 System.out.println("Agregando[" + ajustarNombre(nuevoNodo) + "], con el dato: " + nuevoNodo.getDato() + ", en la posicion: " + posicion);
                
            } else {
                Nodo temporal = cabeza;//creamos un nodo temporal que copie a nuestro nodo cabeza
                
                for (int i = 0; i < posicion - 1; i++) {//este for hace: que tempoal vaya apuntando al nodo siguiente hasta llegar a ser el nodo en la posicion que queremos agregar
                    temporal = temporal.getSiguiente();
                }
                Nodo siguiente = temporal.getSiguiente();//creamos un nuevo nodo temporal llamdo siguiente y lo igualamos al nodo siguiente de temporal(es decir, al nodo siguiente de la posicion que queremos agregar)
                System.out.println("Agregando[" + ajustarNombre(nuevoNodo) + "], con el dato: " + nuevoNodo.getDato() + ", en la posicion: " + posicion);
                temporal.setSiguiente(nuevoNodo);//hacemos que nuestro temporal apunte al nuestro nuevo nodo(es decir, que nuestra cabeza apunte a nuestro nuevo nodo, agrgandolo a la lista)
                nuevoNodo.setSiguiente(siguiente);//hacemos que nuestro nuevo nodo apunte al nodo siguiente de la lista(es decir, que nuestro nuevo nodo apunte al nodo al que estaba apuntando nuestro nodo temporal, completnado nuestra lista)
            }
            tamano++;
        } else {
            System.err.println("la posicion: " + posicion + ", no existe.");
        }
    }
    
    public void eliminar(int posicion){
        if (posicion >= 0 && posicion < tamano) {//Este if hace: Evalua que la posicion que nos dieron sea mayor o igual que 0 y menor al tamaño de nuestra lista
            if (posicion == 0) {//Este if hace: si la posicion que nos dieron es 0, entonce hacemos que la cabeza sea el siguiente a nuestra cabeza actual(es decir, que la cabeza sea el nodo siguiete eliminando a nuestra cabeza)
                cabeza = cabeza.getSiguiente();
            } else {
                Nodo temporal = cabeza;//creamos un nodo temporal que copie a nuestro nodo cabeza
                
                for (int i = 0; i < posicion-1; i++) {//este for hace: que tempoal vaya apuntando al nodo siguiente hasta llegar a ser el nodo anterior al nodo que queremos eliminar
                    temporal = temporal.getSiguiente();
                }
                Nodo siguiente = temporal.getSiguiente();//creamos un nuevo nodo temporal llamdo siguiente y lo igualamos al nodo siguiente de temporal(es decir, al nodo que queremos eliminar)
                temporal.setSiguiente(siguiente.getSiguiente());//hacemos que temporal apunte al nodo siguiente del nodo siguiente(es decir, que apunte al nodo siguiente del nodo que queremos eliminar)
            }
            tamano--;
        } else {
            System.err.println("la posicion: " + posicion + ", no existe.");
        }
    }
}
