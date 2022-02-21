package br.edu.uni7.aed2.a01listadupla;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

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
