package br.edu.uni7.aed2;

import br.edu.uni7.aed2.grafo.Aresta;
import br.edu.uni7.aed2.grafo.Grafo;
import br.edu.uni7.aed2.grafo.Vertice;
import br.edu.uni7.aed2.grafo.Visitante;

public class Main {
    public static void main(String[] args) {
        boolean[][] matrizAdjacencia = new boolean[][]{
                {false, true, true, false, false}, //0
                {true, false, true, true, false}, //1
                {true, true, false, false, true}, //2
                {false, true, false, false, true},//3
                {false, false, true, true, false},//4
        };

        Grafo grafo = Grafo.lerMatrizDeAdjacencia(matrizAdjacencia);
        System.out.println(grafo);

        Vertice inicio = grafo.getVertices().iterator().next();
        grafo.dfs(inicio, (vertice, aresta) -> {
            System.out.println("V: " + vertice + " A: " + aresta);
            return false;
        });
    }
}
