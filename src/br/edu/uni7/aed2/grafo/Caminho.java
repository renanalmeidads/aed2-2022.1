package br.edu.uni7.aed2.grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Caminho {

    private final List<Aresta> arestas;

    public Caminho(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    @Override
    public String toString() {
        return arestas.toString();
    }

    public static Caminho encontrarCaminho(Grafo grafo, Vertice x, Vertice y) {
        Stack<Aresta> percurso = new Stack<>();
        grafo.bfs(x, ((vertice, aresta) -> {
            if (aresta != null) {
                percurso.push(aresta);
            }

            return vertice.equals(y);
        }));

        List<Aresta> caminhoXY = new ArrayList<>();
        Vertice verticeFinal = y;

        while (!percurso.isEmpty()) {
            Aresta aresta = percurso.pop();
            if (aresta.pertence(verticeFinal)) {
                verticeFinal = aresta.getVizinho(verticeFinal);
                caminhoXY.add(0, aresta);
            }
        }

        return new Caminho(caminhoXY);
    }

}
