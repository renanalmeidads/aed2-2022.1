package br.edu.uni7.aed2;

import br.edu.uni7.aed2.grafo.Grafo;
import br.edu.uni7.aed2.grafo.Vertice;
import br.edu.uni7.aed2.grafo.Visitante;

public class Main {
    public static void main(String[] args) {
        boolean[][] matrizAdjacencia = new boolean[][]{
                {false, true, true, false, false},
                {true, false, false, true, false},
                {true, false, false, false, true},
                {false, true, false, false, false},
                {false, false, true, false, false},
        };

        Grafo grafo = Grafo.lerMatrizDeAdjacencia(matrizAdjacencia);

        grafo.bfs(grafo.getVerticeNoIndice(0), vertice -> {
            System.out.print(vertice.getValor() + " ");
            return false;
        });
    }
}
