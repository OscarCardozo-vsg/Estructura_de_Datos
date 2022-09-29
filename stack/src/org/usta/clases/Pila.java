package org.usta.clases;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Oscar Javier Cardozo Diaz
 */
public class Pila {

    public static Stack pila = new Stack();
    public static Scanner miTeclado = new Scanner(System.in);
    public static Random rnd = new Random();

    public static void main(String[] args) {
        Integer opcion = -1;
        int valor;
        
        for (int i = 0; i < 5; i++) {
            valor = random(0, 10);
            pila.add(valor);
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
                    System.out.println("buscar");
                    buscar();
                    break;
            }

        }

    }

    public static void menu() {
        System.out.println("Menu de opciones de pila: ");
        System.out.println("--------------------------");
        System.out.println("1. agregar");
        System.out.println("2. agregar por posicion");
        System.out.println("3. imprimir metodo 1");
        System.out.println("4. imprimir metodo 2");
        System.out.println("5. eliminar");
        System.out.println("6. eliminar por posicion");
        System.out.println("7. primero de la pila");
        System.out.println("8. tamaño de la pila");
        System.out.println("9. buscar");
        System.out.println("0. salir");
        System.out.println("--------------------------");
    }
    
    public static int random(int inicio, int fin){
        int valor = rnd.nextInt(fin - inicio + 1) + inicio;
        return valor;
    } 

    public static boolean esVacio(){
        return pila.empty();
    }
    
    public static Integer tamano(){
        return pila.size();
    }
    
    public static Integer buscar(){
        Object dato = miTeclado.next();
        return pila.search(dato);
    }
    
    public static Object elPrimero(){
        return pila.peek();
    }
    
    public static void agregar(){
        System.out.println("Que valor va a agregar?: ");
        String valor = miTeclado.next();
        pila.push(valor);
    }
    
    public static void agregarPosicion(){
        System.out.println("Que valor va a agregar?: ");
        Object valor = miTeclado.next();
        System.out.println("En que posicion lo quieres agregar?: ");
        int posicion = miTeclado.nextInt();
        
        if (posicion <= tamano()) {
            pila.add(posicion, valor);
        } else {
            System.out.println("Posicion no valida.");
        }
    }
    
    public static void imprimir(){
        if (!esVacio()) {
            int indice = tamano();
            Iterator iterator = pila.iterator();
            
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
            pila.forEach(dato->{
                System.out.println("La pila["+indice+"], tiene el dato --->"+dato);
                indice.getAndDecrement();
            });
            System.out.println("*******************************");
        } else {
            System.out.println("La pila esta vacia");
        }
    }
    
    public static void eliminar(){
        Object valor = pila.pop();
        System.out.println("Elemento eliminado ---->"+valor);
    }
    
    public static void eliminarPosicion(){
        System.out.println("Digite la posicion: ");
        Integer posicion = miTeclado.nextInt();
        posicion = posicion - tamano();
        
        if (posicion <= tamano()) {
            pila.removeElementAt(posicion);
        } else {
            System.out.println("Posicion no valida.");
        }
    }
}

