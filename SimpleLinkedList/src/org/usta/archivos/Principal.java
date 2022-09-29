package org.usta.archivos;

import java.util.Random;
import org.usta.misclases.listaSimple;

/*
@author Oscar Javier Cardozo Diaz
 */
public class Principal {

    public static void main(String[] args) {
        listaSimple lista = new listaSimple();//para crear una lista

        for (int i = 0; i < 5; i++) {
            int valor = demeloya(1, 20);
            lista.agregar(valor);//para agregar un dato al nuevo nodo que estamos creando
        }
        lista.agregarPosicion(1, 9);
        lista.agregarPosicion(0, 6);
        lista.eliminar(4);
        lista.imprimir();

    }

    public static int demeloya(int Inicio, int Final) {
        Random Rdm = new Random();
        int Valor = Rdm.nextInt(Final - Inicio + 1) + Inicio;
        return Valor;
    }
}
