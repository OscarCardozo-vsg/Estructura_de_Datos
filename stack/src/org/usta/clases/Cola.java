package org.usta.clases;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import static org.usta.clases.Pila.rnd;

public class Cola {    
    public static LinkedList cola = new LinkedList();
    public static Scanner miTeclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        Integer opcion = -1;
        int valor;
        
        for (int i = 0; i < 5; i++) {
            valor = random(0, 10);
            cola.add(valor);
        }

        while (opcion != 0) {
            menu();
            opcion = miTeclado.nextInt();

            switch (opcion) {
                case 1: 
                    System.out.println("agregar"); 
                    agregar();
                    break;
                case 2:
                    System.out.println("agregar por posicion");
                    agregarPosicion();
                    break;
                case 3:
                    System.out.println("imprimir metodo 1");
                    imprimir();
                    break;
                case 4:
                    System.out.println("imprimir metodo 2");
                    imprimir2();
                    break;
                case 5:
                    System.out.println("eliminar");
                    eliminar();
                    break;
                case 6: 
                    System.out.println("eliminar por posicion");
                    eliminarPosicion();
                    break;
                case 7:
                    System.out.println("primero de la pila");
                    elPrimero();
                    break;
                case 8:
                    System.out.println("tamaño de la pila");
                    tamano();
                    break;
                case 9:
                    break;
            }

        }
    }
    
     public static void menu() {
        System.out.println("Menu de opciones de cola: ");
        System.out.println("--------------------------");
        System.out.println("1. agregar");
        System.out.println("2. agregar por posicion");
        System.out.println("3. imprimir metodo 1");
        System.out.println("4. imprimir metodo 2");
        System.out.println("5. eliminar");
        System.out.println("6. eliminar por posicion");
        System.out.println("7. primero de la pila");
        System.out.println("8. tamaño de la pila");
        System.out.println("9. buscar <no tiene>");
        System.out.println("0. salir");
        System.out.println("--------------------------");
    }
    
    public static int random(int inicio, int fin){
        int valor = rnd.nextInt(fin - inicio + 1) + inicio;
        return valor;
    } 

    public static boolean esVacio(){
        return cola.isEmpty();
    }
    
    public static Integer tamano(){
        return cola.size();
    }
 
public static Object elPrimero(){
        return cola.peek();
    }
    
    public static void agregar(){
        System.out.println("Que valor va a agregar?: ");
        String valor = miTeclado.next();
        cola.push(valor);
    }
    
    public static void agregarPosicion(){
        System.out.println("Que valor va a agregar?: ");
        Object valor = miTeclado.next();
        System.out.println("En que posicion lo quieres agregar?: ");
        int posicion = miTeclado.nextInt();
        
        if (posicion <= tamano()) {
            cola.add(posicion, valor);
        } else {
            System.out.println("Posicion no valida.");
        }
    }
    
    public static void imprimir(){
        if (!esVacio()) {
            int indice = tamano();
            Iterator iterator = cola.iterator();
            
            System.out.println("*******************************");
            while (iterator.hasNext()) {                
                Object dato = iterator.next();
                System.out.println("La pila["+indice+"], tiene el dato --->"+dato);
                indice--;
            }
            System.out.println("*******************************");
        } else {
            System.out.println("La pila esta vacia.");
        }
    }
    
    public static void imprimir2(){
        if (!esVacio()) {
            AtomicInteger indice = new AtomicInteger(tamano());
            
            System.out.println("*******************************");
            cola.forEach(dato->{
                System.out.println("La pila["+indice+"], tiene el dato --->"+dato);
                indice.getAndDecrement();
            });
            System.out.println("*******************************");
        } else {
            System.out.println("La pila esta vacia");
        }
    }
    
    public static void eliminar(){
        Object valor = cola.pop();
        System.out.println("Elemento eliminado ---->"+valor);
    }
    
//    public static void eliminarPosicion(){
//        System.out.println("Digite la posicion: ");
//        Integer posicion = miTeclado.nextInt();
//        posicion = posicion - tamano();
//        
//        if (posicion <= tamano()) {
//            cola.remove(posicion);
//        } else {
//            System.out.println("Posicion no valida.");
//        }
//    }
    
    public static void eliminarPosicion(){
        System.out.println("Digite la posicion: ");
        Integer posicion = miTeclado.nextInt();
        
        Object mostrar = cola.remove(posicion);
    }
}
