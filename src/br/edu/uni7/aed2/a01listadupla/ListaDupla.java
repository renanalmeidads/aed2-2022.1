package br.edu.uni7.aed2.a01listadupla;

public class ListaDupla {

    No inicio;
    No fim;
    int tamanho;

    public ListaDupla() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

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

        tamanho++;
    }

    public void imprimir() {
        No noAtual = inicio;
        while (noAtual != null) {
            System.out.println(noAtual.valor);
            noAtual = noAtual.proximo;
        }
    }

    public int valorNaPosicao(int posicao) {
        No noAtual = inicio;
        while (noAtual != null) {
            if (posicao == 0) {
                return noAtual.valor;
            }
            posicao--;
            noAtual = noAtual.proximo;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public void valorNaPosicao(int posicao, int valor) {
        No noAtual = inicio;
        while (noAtual != null) {
            if (posicao == 0) {
                noAtual.valor = valor;
                break;
            }
            posicao--;
            noAtual = noAtual.proximo;
        }
    }


    public void reverter() {
        //2.9 segundos
//        int[] array = new int[tamanho];
//
//        int j = 0;
//        for (int i = tamanho - 1; i >= 0; i--) {
//            array[j] = valorNaPosicao(i);
//            j++;
//        }


        for (int i = 0; i < tamanho / 2; i++) {
            int valorNoFinal = valorNaPosicao(tamanho - 1 - i);
            int valorNoInicio = valorNaPosicao(i);

            valorNaPosicao(i, valorNoFinal);
            valorNaPosicao(tamanho - 1 - i, valorNoInicio);
        }

    }
}
