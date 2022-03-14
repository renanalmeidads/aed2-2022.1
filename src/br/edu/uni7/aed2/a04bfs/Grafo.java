package br.edu.uni7.aed2.a04bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {

    private final List<Vertice> vertices;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public boolean bfs(Vertice inicio, int valor) {
        Queue<Vertice> fila = new LinkedList<>();
        boolean[] visitados = new boolean[vertices.size()];

        fila.add(inicio);
        visitados[vertices.indexOf(inicio)] = true;

        while (!fila.isEmpty()) {
            Vertice vertice = fila.poll();

            System.out.println("Processando vertice: " + vertice.getValor());
            if (vertice.getValor() == valor) {
                return true;
            }

            for (Vertice vizinho : vertice.getVizinhos()) {
                int indiceVizinho = vertices.indexOf(vizinho);

                if (!visitados[indiceVizinho]) {
                    fila.add(vizinho);
                    visitados[indiceVizinho] = true;
                }
            }
        }

        return false;
    }

    public void addVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public Vertice getVerticeNoIndice(int indice) {
        return vertices.get(indice);
    }

}
