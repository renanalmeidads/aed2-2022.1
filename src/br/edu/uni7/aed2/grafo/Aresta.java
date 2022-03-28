package br.edu.uni7.aed2.grafo;

public class Aresta {

    private final Vertice verticeA;
    private final Vertice verticeB;

    public Aresta(Vertice verticeA, Vertice verticeB) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
    }

    public Vertice getVerticeA() {
        return verticeA;
    }

    public Vertice getVerticeB() {
        return verticeB;
    }

    public Vertice getVizinho(Vertice vertice) {
        if (getVerticeA() != vertice && getVerticeB() == vertice) {
            return getVerticeA();
        } else if (getVerticeA() == vertice && getVerticeB() != vertice) {
            return getVerticeB();
        }

        throw new IllegalArgumentException("O vértice informado não pertence a esta aresta");
    }
}
