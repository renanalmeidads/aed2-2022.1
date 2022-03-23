package br.edu.uni7.aed2;

import br.edu.uni7.aed2.grafo.Grafo;
import br.edu.uni7.aed2.grafo.Vertice;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Vertice vertice = new Vertice(9);
        grafo.adicionarVertice(vertice);

        boolean resultado = grafo.bfs(vertice, 9);
        System.out.println(resultado);
    }
}
