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

    public void bfs(Vertice inicio, Visitante visitante) {
        Queue<Vertice> fila = new LinkedList<>();
        Queue<Aresta> filaArestas = new LinkedList<>();
        Set<Vertice> visitados = new HashSet<>();

        fila.add(inicio);
        visitados.add(inicio);

        while (!fila.isEmpty()) {
            Vertice vertice = fila.poll();

            if (visitante.visitar(vertice, filaArestas.poll())) {
                return;
            }

            for (Aresta aresta : vertice.getArestas()) {
                Vertice vizinho = aresta.getVizinho(vertice);

                if (!visitados.contains(vizinho)) {
                    fila.add(vizinho);
                    filaArestas.add(aresta);
                    visitados.add(vizinho);
                }
            }
        }
    }

    public void dfs(Vertice inicio, Visitante visitante) {
        Stack<Vertice> pilha = new Stack<>();
        Stack<Aresta> pilhaArestas = new Stack<>();
        Set<Vertice> visitados = new HashSet<>();

        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            Vertice vertice = pilha.pop();
            if (!visitados.contains(vertice)) {
                Aresta topo = pilhaArestas.size() > 0 ? pilhaArestas.pop() : null;
                if (visitante.visitar(vertice, topo)) {
                    return;
                }

                visitados.add(vertice);

                for (Aresta aresta : vertice.getArestas()) {
                    pilha.push(aresta.getVizinho(vertice));
                    pilhaArestas.push(aresta);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "G(V=" + vertices + ", E=" + arestas + ")";
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
                    Aresta aresta = new Aresta(verticeA, verticeB);
                    verticeA.adicionar(aresta);
                    verticeB.adicionar(aresta);
                }
            }
        }

        return new Grafo(new HashSet<>(vertices));
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

                Aresta aresta = new Aresta(verticeA, verticeAdjacente);
                verticeA.adicionar(aresta);
                verticeAdjacente.adicionar(aresta);
            }
        }

        return new Grafo(new HashSet<>(vertices));
    }

}
