package org.usta.archivos;

import java.util.Random;
import org.usta.misclases.ListaDoble;

/**
 *
 * @author Oscar Javier Cardozo Diaz
 */
public class Principal {
    
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();
        
        for (int i = 0; i < 5; i++) {
            int dato = numRandom(1, 10);     
            
           lista.agregar(dato);                   
        }  
        lista.imprimir();
        lista.eliminar(3);
        lista.imprimir();
        lista.imprimirAlRevez();
    }
    
    public static int numRandom(int inicio, int fin){
        Random rnd = new Random();
        int valor = rnd.nextInt(fin - inicio + 1) + inicio;    
        return valor;
    } 
}
