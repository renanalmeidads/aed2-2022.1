package br.edu.uni7.aed2;

import br.edu.uni7.aed2.listadupla.ListaDupla;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.


        ListaDupla listaDupla = new ListaDupla();

        for (int i = 0; i < 1_000_000; i++) {
            listaDupla.inserir(i);
        }

        //listaDupla.imprimir();

        long inicio = System.currentTimeMillis();
        listaDupla.reverter();
        long fim = System.currentTimeMillis();
        long tempoTotal = fim - inicio;
        System.out.println(tempoTotal + " ms");
    }

}
