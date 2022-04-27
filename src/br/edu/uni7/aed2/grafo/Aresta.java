package br.edu.uni7.aed2.grafo;

import java.util.Random;

public class Aresta<V> {

    private final Vertice<V> verticeA;
    private final Vertice<V> verticeB;
    private Integer peso;
    private String descricao;

    public Aresta(Vertice<V> verticeA, Vertice<V> verticeB) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = new Random().nextInt(25);
    }

    public Aresta(Vertice<V> verticeA, Vertice<V> verticeB, Integer peso, String descricao) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = peso;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        descricao = descricao;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Vertice<V> getVerticeA() {
        return verticeA;
    }

    public Vertice<V> getVerticeB() {
        return verticeB;
    }

    public Vertice<V> getVizinho(Vertice vertice) {
        if (getVerticeA() != vertice && getVerticeB() == vertice) {
            return getVerticeA();
        } else if (getVerticeA() == vertice && getVerticeB() != vertice) {
            return getVerticeB();
        }

        throw new IllegalArgumentException("O vértice informado não pertence a esta aresta");
    }

    public boolean pertence(Vertice<V> vertice) {
        return vertice.equals(verticeA) || vertice.equals(verticeB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aresta<V> aresta = (Aresta<V>) o;
        return (verticeA.equals(aresta.verticeA) && verticeB.equals(aresta.verticeB) ||
                verticeA.equals(aresta.verticeB) && verticeB.equals(aresta.verticeA));
    }

    @Override
    public int hashCode() {
        return verticeA.hashCode() + verticeB.hashCode();
    }

    @Override
    public String toString() {
        return "(" + verticeA + ", " + verticeB + ")";
    }
}
