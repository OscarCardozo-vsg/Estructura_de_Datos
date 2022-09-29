package org.usta.misarchivos;

import java.util.Random;
import org.usta.misclases.listaSimpleCircular;

/**
 *
 * @author Oscar Javier Cardozo Diaz
 */
public class Principal {
    private static Random rnd = new Random();
            
    
    public static void main(String[] args) {
        listaSimpleCircular miLista = new listaSimpleCircular();
        
        for (int i = 0; i < 5; i++) {
            int dato = rnd.nextInt(1,10);
            
            miLista.agregar(dato);
        }
        miLista.imprimir();
        miLista.eliminar(0);
        miLista.imprimir();
    }
}
