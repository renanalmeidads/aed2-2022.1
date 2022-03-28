package br.edu.uni7.aed2.grafo;

import java.util.*;

public class Grafo {

    private final Set<Vertice> vertices;
    private final Set<Aresta> arestas;

    public Grafo() {
        this.vertices = new HashSet<>();
        this.arestas = new HashSet<>();
    }

    public Grafo(Set<Vertice> vertices) {
        this.vertices = vertices;
        this.arestas = new HashSet<>();

        for (Vertice vertice : vertices) {
            arestas.addAll(vertice.getArestas());
        }
    }

    public Set<Vertice> getVertices() {
        return vertices;
    }

    public Set<Aresta> getArestas() {
        return arestas;
    }

    public void adicionarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void adicionarAresta(Aresta aresta) {
        arestas.add(aresta);
    }

    public void bfs(Vertice inicio, Visitante visitante) {
        Queue<Vertice> fila = new LinkedList<>();
        Set<Vertice> visitados = new HashSet<>();

        fila.add(inicio);
        visitados.add(inicio);

        while (!fila.isEmpty()) {
            Vertice vertice = fila.poll();

            if (visitante.visitar(vertice)) {
                return;
            }

            for (Aresta aresta : vertice.getArestas()) {
                Vertice vizinho = aresta.getVizinho(vertice);

                if (!visitados.contains(vizinho)) {
                    fila.add(vizinho);
                    visitados.add(vizinho);
                }
            }
        }
    }

    public void dfs(Vertice inicio, Visitante visitante) {
        Stack<Vertice> pilha = new Stack<>();
        Set<Vertice> visitados = new HashSet<>();

        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            Vertice vertice = pilha.pop();
            if (!visitados.contains(vertice)) {
                if (visitante.visitar(vertice)) {
                    return;
                }

                visitados.add(vertice);

                for (Aresta aresta : vertice.getArestas()) {
                    pilha.push(aresta.getVizinho(vertice));
                }
            }
        }
    }

    public static Grafo lerMatrizDeAdjacencia(boolean[][] matriz) {
        int n = matriz.length;

        List<Vertice> vertices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Vertice v = new Vertice(i);
            vertices.add(v);
        }

        for (int i = 0; i < n; i++) {
            Vertice verticeA = vertices.get(i);

            for (int j = 0; j < matriz[i].length; j++) {
                Vertice verticeB = vertices.get(j);

                if (matriz[i][j]) {
                    verticeA.adicionar(verticeB);
                }
            }
        }

        return new Grafo(vertices);
    }

    public static Grafo lerListaDeAdjacencia(List<Integer>[] listaAdjacencia) {
        int n = listaAdjacencia.length;

        List<Vertice> vertices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Vertice vertice = new Vertice(i);
            vertices.add(vertice);
        }

        for (int i = 0; i < n; i++) {
            Vertice verticeA = vertices.get(i);
            List<Integer> adjacentes = listaAdjacencia[i];

            for (Integer adjacente : adjacentes) {
                Vertice verticeAdjacente = vertices.get(adjacente);
                verticeA.adicionar(verticeAdjacente);
            }
        }

        return new Grafo(vertices);
    }

}
