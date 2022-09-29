package org.usta.misarchivos;

import java.util.Random;
import org.usta.misclases.listaDobleCircular;

/**
 *
 * @author Oscar Javier Cardozo Diaz
 */
public class Principal {
    private static Random rnd = new Random();
            
    public static void main(String[] args) {
        listaDobleCircular miLista = new listaDobleCircular();
        
        for (int i = 0; i < 5; i++) {
            int dato = rnd.nextInt(0, 10);
            
            miLista.agregar(dato);
        }
        miLista.imprimir();
    }
}
