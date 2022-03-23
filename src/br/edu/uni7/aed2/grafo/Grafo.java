package br.edu.uni7.aed2.grafo;

import java.util.*;

public class Grafo {

    private final List<Vertice> vertices;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public Grafo(List<Vertice> vertices) {
        this.vertices = vertices;
    }

    public void adicionarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public Vertice getVerticeNoIndice(int indice) {
        return vertices.get(indice);
    }

    public boolean bfs(Vertice inicio, int valor) {
        Queue<Vertice> fila = new LinkedList<>();
        boolean[] visitados = new boolean[vertices.size()];

        fila.add(inicio);
        visitados[vertices.indexOf(inicio)] = true;

        while (!fila.isEmpty()) {
            Vertice vertice = fila.poll();

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

    public boolean dfs(Vertice inicio, int valor) {
        Stack<Vertice> pilha = new Stack<>();
        boolean[] visitados = new boolean[vertices.size()];

        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            Vertice topoPilha = pilha.pop();
            int indiceDoTopoNaListaDeVizinhos = vertices.indexOf(topoPilha);
            if (!visitados[indiceDoTopoNaListaDeVizinhos]) {

                System.out.print(topoPilha.getValor() + " ");
                if (valor == topoPilha.getValor()) {
                    return true;
                }

                visitados[indiceDoTopoNaListaDeVizinhos] = true;

                for (Vertice vertice : topoPilha.getVizinhos()) {
                    pilha.push(vertice);
                }
            }
        }

        return false;
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
