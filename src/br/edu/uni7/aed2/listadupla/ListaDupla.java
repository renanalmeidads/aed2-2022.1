package br.edu.uni7.aed2.listadupla;

public class ListaDupla {

    No inicio;
    No fim;

    public void inserir(int valor) {
        No no = new No();
        no.valor = valor;

        if (inicio == null) {
            inicio = no;
        } else {
            no.anterior = fim;
            no.proximo = null;
            fim.proximo = no;
        }

        fim = no;
    }

}
