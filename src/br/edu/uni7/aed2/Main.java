package br.edu.uni7.aed2;

import br.edu.uni7.aed2.grafo.Aresta;
import br.edu.uni7.aed2.grafo.Caminho;
import br.edu.uni7.aed2.grafo.Grafo;
import br.edu.uni7.aed2.grafo.Vertice;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        boolean[][] matrizAdjacencia = new boolean[][]{
                {false, true, true, false, false},//0
                {true, false, true, true, false}, //1
                {true, true, false, false, true}, //2
                {false, true, false, false, true},//3
                {false, false, true, true, false},//4
        };

        Grafo grafo = Grafo.lerMatrizDeAdjacencia(matrizAdjacencia);
        System.out.println(grafo);

        Vertice x = grafo.getVertice(0);
        Vertice y = grafo.getVertice(3);
        Caminho caminho = Caminho.dijkstra(grafo, x, y);
        System.out.println("O caminho entre 0 e 4 é: " + caminho);
    }
}
