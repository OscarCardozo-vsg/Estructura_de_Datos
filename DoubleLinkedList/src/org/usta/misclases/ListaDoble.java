package org.usta.misclases;

public class ListaDoble {

    public Nodo cabeza, cola;
    public int tamano;

    public ListaDoble() {
        inicializar();
    }

    private void inicializar() {
        cabeza = null;
        cola = null;
        tamano = 0;
    }

    public int getTamano() {
        return tamano;
    }

    public void agregar(Object datoAgregar) {
        Nodo nuevoNodo = new Nodo(datoAgregar, cola, null);//creamos nuestro nuevo nodo con el dato dado, ademas conectamos el apuntador anterior de nuestro nuevoNodo a la cola y no conectamos el apuntador siguiente a null
        
        if(cabeza == null){//este if hace: evalua si tenemos una cabeza en nuestra lista, si no tiene, hacemos a nuestro nuevoNodo la cabeza
            cabeza = nuevoNodo;
        }
        if(cola != null){//este if hace: evalua si nuestra lista tiene una cola, si tiene una cola, entonces, conectamos la cola a nuestro nuevoNodo(psdt:al crear nuestro nodo lo conectamos de una vez a la cola de la lista)
            cola.setSiguiente(nuevoNodo);
        }
        cola = nuevoNodo;//hacemos que nuestro nuevoNodo se vuelva la nueva cola de la lista
        tamano++;
    }
    
    public void eliminar(int posicion){
        if(posicion>=0 && posicion<tamano){//Este if hace: evalua que la posicion sea mayor a 0 y menor al tamaño de nuestra lista
            if (posicion == 0) {//Este if hace: evalua que la posicion que le dimos sea 0(es decir que sea el primero de nuestra lista), si lo es entonces, hacemos que el nodo siguiente a nuestra cabeza sea la nueva cabeza, y a su vez que esta nueva cabeza no este conectada con ningun nodo anterior
                cabeza = cabeza.getSiguiente();
                cabeza.setAnterior(null);
            }else{
                if(posicion==tamano-1){//Este if hace: evalua que la posicion dada sea el ultimo de nuestra lista, si lo es entonces, hacemos que el nodo anteriror a la cola sea nuestra nueva cola, y a su vez hacemos que esta nueva cola no este conectado con ningun nodo siguiente
                    cola = cola.getAnterior();
                    cola.setSiguiente(null);
                }else{//si no se cumple nada de lo anterior entonces:
                    Nodo temporal = cabeza;//hacemos un nodo que copie a nuestro nodo cabeza
                    
                    for (int i = 0; i < posicion; i++) {//este for hace: que nuestro temporal se iguale al nodo en la posicion que le dimos
                        temporal=temporal.getSiguiente();
                    }               
                    System.out.println("Temporal clono el nodo--->["+ajustarNombre(temporal)+"], en la posicion: "+posicion);
                    
                    Nodo anterior=temporal.getAnterior();//hacemos un nodo que copie al nodo anteriror de nuestro nodo temporal
                    Nodo siguiente=temporal.getSiguiente();//hacemos un nodo que copie al nodo siguiente de nuestro nodo temporal
                    
                    anterior.setSiguiente(siguiente);//hacemos que nuestro nodo anterior a temporal se conecte con el nodo siguiente a temporal
                    siguiente.setAnterior(anterior);//hacemos que nuestro nodo siguiente a temporal se conecte con el nodo anteriro a temporal
                }
                tamano--;
            }
 
        }else{System.out.println("No sea ahuevado y coloque una posicion valida >:C");}
    }
    
    public void imprimir(){
        int indice = 0;
        Nodo temporal = cabeza;

        System.out.println("------------------------------------------------------------------------------------------------------");
        while (temporal != null) {//este while hace: mientras que nuestra lista contenga al menos un nodo, entonces que muestre el nodo y pase al siguiente nodo hasta que no haya nigun nodo siguiente
            System.out.println("El nodo N°[" + indice + "], identificado con [" + ajustarNombre(temporal) + "] tiene el dato de: (" + temporal.getDato() + "), esta apuntando al nodo anterior ---->[" + ajustarNombre(temporal.getAnterior())+"], y esta apuntando al nodo siguiente ---->"+ajustarNombre(temporal.getSiguiente()));
            temporal = temporal.getSiguiente();
            indice++;
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
    }
    
    public void imprimirAlRevez(){
        int indice = tamano-1;
        Nodo temporal = cola;
        System.out.println("------------------------------------------------------------------------------------------------------");
        while (temporal != null) {//este while hace: mientras que nuestra lista contenga al menos un nodo, entonces que muestre el nodo y pase al siguiente nodo hasta que no haya nigun nodo siguiente
            System.out.println("El nodo N°[" + indice + "], identificado con [" + ajustarNombre(temporal) + "] tiene el dato de: (" + temporal.getDato() + "), esta apuntando al nodo anterior ---->[" + ajustarNombre(temporal.getAnterior())+"], y esta apuntando al nodo siguiente ---->"+ajustarNombre(temporal.getSiguiente()));
            temporal = temporal.getAnterior();
            indice--;
        }
         System.out.println("------------------------------------------------------------------------------------------------------");
    }
    
    private String ajustarNombre(Nodo objeto) {
        if (objeto == null) {
            return "Null";
        } else {
            String miTexto = objeto.toString();
            String salida = miTexto.substring(miTexto.indexOf("@") + 1);//sirve para acortar la palabra, segun lo que colocamos tomamos desde el @ en adelante
            return salida.trim();
        }
    }
}
